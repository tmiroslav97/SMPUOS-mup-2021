package rs.uns.acs.ftn.VehicleService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.VehicleService.dto.ExamDTO;
import rs.uns.acs.ftn.VehicleService.model.ExamPOJO;
import rs.uns.acs.ftn.VehicleService.model.PersonPOJO;
import rs.uns.acs.ftn.VehicleService.model.enums.RoleEnum;
import rs.uns.acs.ftn.VehicleService.repository.ExamRepository;
import rs.uns.acs.ftn.VehicleService.repository.PersonRepository;
import rs.uns.acs.ftn.VehicleService.util.Utility;

import java.util.ArrayList;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    LessonService lessonService;

    public ArrayList<ExamDTO> getExams () {
        ArrayList<ExamDTO> retVal = new ArrayList<ExamDTO>();
        for (ExamPOJO e : examRepository.findAll()) {
            retVal.add(new ExamDTO(e));
        }
        return retVal;
    }

    public String add (ExamDTO dto) {
        // Ima li podataka?
        if (dto.getExaminar() == null) {
            return "You must submitt an examiner";
        }
        if (dto.getDate() == null) {
            return "You must submit a date";
        }
        if (dto.getStudent() == null) {
            return "You must submit a student";
        }
        if (dto.getPassed() == null) {
            return "You must submit a pass status";
        }
        // Parsiraj
        ExamPOJO exam = new ExamPOJO();
        exam.setDate(Utility.strToCal(dto.getDate()));
        ArrayList<PersonPOJO> student = personRepository.getPersonByUID(dto.getStudent());
        ArrayList<PersonPOJO> examinar = personRepository.getPersonByUID(dto.getExaminar());
        if (student.size() != 1) {
            return "Student not found! ";
        }
        if (student.get(0).getRole() != RoleEnum.STUDENT) {
            return "Student not eligible! ";
        }
        if (examinar.size() != 1) {
            return "Examiner not found! ";
        }
        if (examinar.get(0).getRole() != RoleEnum.INSTRRUCTOR) {
            return "Examinar not eligible! ";
        }
        exam.setExaminar(examinar.get(0));
        exam.setStudent(student.get(0));
        if (lessonService.canTakeExam(dto.getStudent()) == false) {
            return "Student not eligible to take exam! ";
        }
        if (dto.getPassed().equals("false")) {
            exam.setPassed(false);
        } else if (dto.getPassed().equals("true")) {
            exam.setPassed(true);
            PersonPOJO p = personRepository.getPersonByUID(student.get(0).getUID()).get(0);
            p.setRole(RoleEnum.DRIVER);
            personRepository.save(p);
        }
        examRepository.save(exam);
        return "Exam successfully added! ";
    }



}
