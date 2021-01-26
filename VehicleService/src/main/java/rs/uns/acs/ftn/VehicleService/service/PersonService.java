package rs.uns.acs.ftn.VehicleService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import rs.uns.acs.ftn.VehicleService.dto.CheckPersonDTO;
import rs.uns.acs.ftn.VehicleService.dto.PersonDTO;
import rs.uns.acs.ftn.VehicleService.dto.RecordDTO;
import rs.uns.acs.ftn.VehicleService.dto.TicketDTO;
import rs.uns.acs.ftn.VehicleService.model.LicencePOJO;
import rs.uns.acs.ftn.VehicleService.model.PersonPOJO;
import rs.uns.acs.ftn.VehicleService.model.TicketPOJO;
import rs.uns.acs.ftn.VehicleService.model.enums.RoleEnum;
import rs.uns.acs.ftn.VehicleService.repository.LicenceRepository;
import rs.uns.acs.ftn.VehicleService.repository.PersonRepository;
import rs.uns.acs.ftn.VehicleService.util.Utility;
import sun.awt.X11.XSystemTrayPeer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LicenceRepository licenceRepository;


    public ArrayList<PersonDTO> getPersons() {
        ArrayList<PersonDTO> retVal = new ArrayList<PersonDTO>();
        for (PersonPOJO p : personRepository.findAll()) {
            PersonDTO temp = new PersonDTO(p);
            retVal.add(temp);
        }
        return retVal;
    }

    public String signIn(PersonDTO p) {
        // Provera podataka
        if (p.getlName() == null) {
            return "You must submit the candidates last name. ";
        }
        if (p.getfName() == null) {
            return  "You must submit the candidates first name. ";
        }
        if (p.getUID() == null) {
            return "You must submit the candidates OID. ";
        }
        if (p.getBirthday() == null) {
            return "You must submit the candidates birthdate. ";
        }
        if (Utility.strToCal(p.getBirthday()) == null) {
            return "You must submit the candidates birthdate. ";
        }
        PersonPOJO student = new PersonPOJO(p);
        // Proveri interno
        Integer duplicates = personRepository.countByUID(student.getUID());
        if (duplicates > 0) {
            return "The candidate is already in the system. ";
        }
        // Proveri godine
        Calendar now = Calendar.getInstance();
        Calendar shift = Calendar.getInstance();
        shift.set(Calendar.YEAR, student.getBirthday().get(Calendar.YEAR) + 18);
        shift.set(Calendar.MONTH, student.getBirthday().get(Calendar.MONTH));
        shift.set(Calendar.DAY_OF_MONTH, student.getBirthday().get(Calendar.DAY_OF_MONTH) - 1);
        System.out.println("* shiftL " + Utility.calToStr(shift));
        System.out.println("* now " + Utility.calToStr(now));
        Integer diff = now.compareTo(shift);
        System.out.println("* DiffL " + diff);

        if (diff <=  0) {
            return "The candidate is too young. ";
        }
        // Proveri sa centralom
        ////////////////////////////
        // TODO
        CheckPersonDTO checkPerson = new CheckPersonDTO(p);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String data = "{" +
                "\"name\": \"" + checkPerson.getName() +
                "\", \"surname\": \"" + checkPerson.getSurname() +
                "\", \"uid\": \"" + checkPerson.getUid() +
                "\", \"fathersName\": \"" + checkPerson.getFathersName() +
                "\" }";
        HttpEntity<?> entity = new HttpEntity<Object>(data, headers);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8083/citizen/exists", HttpMethod.PUT, entity, Boolean.class);
        Boolean exists = responseEntity.getBody();
        if (!exists) {
            return "The person is not a registered citizen. ";
        }

        ////////////////////////////

        // Upisi ucenika
        student.setRole(RoleEnum.STUDENT);
        personRepository.save(student);

        return "Candidate is signed up";
    }


    public String makeInstructor(String uid) {
        // Proveri da li postoji
        ArrayList<PersonPOJO> instructors = personRepository.getPersonByUID(uid);
        if (instructors.size() != 1) {
            return "The UID matches no person. ";
        }
        PersonPOJO instructor = instructors.get(0);
        // Proveri da li je vozac
        if (instructor.getRole() != RoleEnum.DRIVER) {
            return "The person is not elligible to become an instructor";
        }
        // Promeni mu status
        instructor.setRole(RoleEnum.INSTRRUCTOR);
        personRepository.save(instructor);
        return "An instructor is born";
    }


    public RecordDTO getRecord (String UID) {
        RecordDTO retVal = new RecordDTO();
        ArrayList<PersonPOJO> person = personRepository.getPersonByUID(UID);
        if (person.size() != 1) {
            return null;
        }
        retVal.setfName(person.get(0).getfName());
        retVal.setlName(person.get(0).getlName());
        retVal.setExpired("true");

        List<LicencePOJO> licences = licenceRepository.getByID(person.get(0).getID());
        Integer sum = 0;
        for (LicencePOJO l : licences) {
            System.out.println(" * Licenca");
            for (TicketPOJO t : l.getTickets()) {
                System.out.println(" * Tiket");
                sum += t.getPoints();
            }
            if (l.isValid()) {
                retVal.setExpired("false");
                retVal.setExpirationDate(Utility.calToStr(l.getExpirationDate()));
            }
        }
        retVal.setPoints(sum);

        return retVal;
    }

}
