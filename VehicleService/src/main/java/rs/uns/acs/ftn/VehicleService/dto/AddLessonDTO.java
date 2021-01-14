package rs.uns.acs.ftn.VehicleService.dto;

import java.util.Calendar;

public class AddLessonDTO<pruvate> {

    private String instructorId;

    private String studentId;

    private String date;

    private String subject;

    public AddLessonDTO () {

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
}
