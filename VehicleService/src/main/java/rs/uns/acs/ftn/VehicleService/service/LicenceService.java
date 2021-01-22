package rs.uns.acs.ftn.VehicleService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.VehicleService.dto.LicenceDTO;
import rs.uns.acs.ftn.VehicleService.model.LicencePOJO;
import rs.uns.acs.ftn.VehicleService.model.PersonPOJO;
import rs.uns.acs.ftn.VehicleService.model.enums.RoleEnum;
import rs.uns.acs.ftn.VehicleService.repository.LicenceRepository;
import rs.uns.acs.ftn.VehicleService.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class LicenceService {

    @Autowired
    LicenceRepository licenceRepository;

    @Autowired
    PersonRepository personRepository;

    public ArrayList<LicenceDTO> getLicences() {
        ArrayList<LicenceDTO> retVal = new ArrayList<LicenceDTO>();
        for (LicencePOJO l : licenceRepository.findAll()) {
            retVal.add(new LicenceDTO((l)));
        }
        return retVal;
    }

    public String add(LicenceDTO dto) {
        if (dto.getHolder() == null) {
            return "Please submit a holder";
        }

        ArrayList<PersonPOJO> holder = personRepository.getPersonByUID(dto.getHolder());
        if (holder.size() != 1) {
            return "User not holder. ";
        }
        if (holder.get(0).getRole() == RoleEnum.STUDENT) {
            return "Holder has not passed their drivers exam. ";
        }
        List<LicencePOJO> previousLicences = licenceRepository.findAll();
        for (LicencePOJO l : previousLicences) {
            if (l.getHolder().getUID().equals(dto.getHolder())) {
                if (l.isValid()) {
                    return "Holder already has a valid licence. ";
                }
            }
        }
        System.out.println(" * Pronadjoh " + previousLicences.size() + " predjasnjih dozvola. ");
        System.out.println(" * Holder id: " + dto.getHolder());
        LicencePOJO licence = new LicencePOJO();

        licence.setHolder(holder.get(0));
        licence.setOriginDate(Calendar.getInstance());
        licence.setExpirationDate(Calendar.getInstance());
        licence.getExpirationDate().set(Calendar.YEAR, licence.getExpirationDate().get((Calendar.YEAR)) + 10);
        licence.setValid(true);
        licenceRepository.save(licence);
        return "Licence successfully created! ";
    }
}
