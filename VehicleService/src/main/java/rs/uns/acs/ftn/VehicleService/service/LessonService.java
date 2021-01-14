package rs.uns.acs.ftn.VehicleService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.VehicleService.controller.LessonController;
import rs.uns.acs.ftn.VehicleService.dto.AddLessonDTO;
import rs.uns.acs.ftn.VehicleService.model.LessonPOJO;
import rs.uns.acs.ftn.VehicleService.model.PersonPOJO;
import rs.uns.acs.ftn.VehicleService.model.enums.RoleEnum;
import rs.uns.acs.ftn.VehicleService.model.enums.SubjectEnum;
import rs.uns.acs.ftn.VehicleService.repository.LessonRepository;
import rs.uns.acs.ftn.VehicleService.repository.PersonRepository;
import rs.uns.acs.ftn.VehicleService.util.Utility;

import java.util.ArrayList;
import java.util.Calendar;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    public ArrayList<LessonPOJO> getLessons() {
        ArrayList<LessonPOJO> retVal = new ArrayList<LessonPOJO>();
        for (LessonPOJO l : lessonRepository.findAll()) {
            retVal.add(l);
        }
        return retVal;
    }



    public String addLesson (AddLessonDTO dto) {
        // Proveri izostavljena polja
        if (dto.getDate() == null) {
            return "You must submit a date! ";
        }
        if (dto.getSubject() == null) {
            return "Each lesson must have a subject! ";
        }
        if (dto.getStudentId() == null) {
            return "Please submit a student! ";
        }
        if (dto.getInstructorId() == null) {
            return "Please submit an instructor! ";
        }
        // Generisi POJO
        LessonPOJO newLesson = new LessonPOJO();
        newLesson.setDate(Utility.strToCal(dto.getDate()));
        switch (dto.getSubject()) {
            case "SAFETY":
                newLesson.setSubject(SubjectEnum.SAFETY);
                break;
            case "SIGNS":
                newLesson.setSubject(SubjectEnum.SIGNS);
                break;
            case "OPERATING":
                newLesson.setSubject(SubjectEnum.OPERATING);
                break;
            default:
                return "You have submitted an unvalid subject! ";
        }
        ArrayList<PersonPOJO> student = personRepository.getPersonByUID(dto.getStudentId());
        if (student.size() != 1) {
            return "Student not found! ";
        }
        ArrayList<PersonPOJO> instructor = personRepository.getPersonByUID(dto.getInstructorId());
        if (instructor.size() != 1) {
            return "Instructor not found! ";
        }
        newLesson.setStudent(student.get(0));
        if (newLesson.getStudent().getRole() != RoleEnum.STUDENT) {
            return "Student not found! ";
        }
        newLesson.setInstructor(instructor.get(0));
        if (newLesson.getInstructor().getRole() != RoleEnum.INSTRRUCTOR) {
            return "Instructor not found! ";
        }
        lessonRepository.save(newLesson);
        return "Lesson successfully created. ";
    }

    public Boolean canTakeExam (String UID) {
        System.out.println("* Ulazni UID: " + UID);
        ArrayList<PersonPOJO> person = personRepository.getPersonByUID(UID);
        System.out.println("* person.size: " + person.size());
        if (person.size() != 1) {
            System.out.println("* Nisam nasao osobu");
            return false;
        }
        LessonPOJO l1 = null;
        LessonPOJO l2 = null;
        LessonPOJO l3 = null;
        for (LessonPOJO l : lessonRepository.findAll()) {
            if ((l.getSubject() == SubjectEnum.SAFETY) && (person.get(0).getUID().equals(l.getStudent().getUID()))) {
                System.out.println("* Nasao sam SAFETY");
                l1 = l;
            } else if ((l.getSubject() == SubjectEnum.OPERATING) && (person.get(0).getUID().equals(l.getStudent().getUID()))) {
                System.out.println("* Nisam nasao OPERATING");
                l2 = l;
            } else if ((l.getSubject() == SubjectEnum.SIGNS) && (person.get(0).getUID().equals(l.getStudent().getUID()))) {
                System.out.println("* Nisam nasao SIGNS");
                l3 = l;
            }
        }
        if (l1 != null) {
            if (l2 != null) {
                if (l3 != null) {
                    System.out.println("* Vracam tacno");
                    return true;
                }
            }
        }
        System.out.println("* Nisam nasao sva tri");
        return false;
    }



}
