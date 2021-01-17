package rs.uns.acs.ftn.VehicleService.dto;

import rs.uns.acs.ftn.VehicleService.model.LessonPOJO;
import rs.uns.acs.ftn.VehicleService.model.enums.RoleEnum;
import rs.uns.acs.ftn.VehicleService.model.enums.SubjectEnum;
import rs.uns.acs.ftn.VehicleService.util.Utility;

import java.util.Calendar;

public class LessonDTO<pruvate> {

    private String instructorId;

    private String studentId;

    private String date;

    private String subject;

    private Integer ID;

    public LessonDTO() {

    }

    public String getDate() {
        return date;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public LessonDTO (LessonPOJO pojo) {
        this.ID = pojo.getID();
        this.date = Utility.calToStr(pojo.getDate());
        this.studentId = pojo.getStudent().getUID();
        this.instructorId = pojo.getInstructor().getUID();
        switch (pojo.getSubject()) {
            case OPERATING:
                this.subject = "OPERATING";
                break;
            case SAFETY:
                this.subject = "SAFETY";
                break;
            case SIGNS:
                this.subject = "SIGNS";
                break;
        }
    }

}
