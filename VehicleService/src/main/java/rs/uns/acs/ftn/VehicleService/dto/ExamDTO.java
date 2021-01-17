package rs.uns.acs.ftn.VehicleService.dto;

import rs.uns.acs.ftn.VehicleService.model.ExamPOJO;
import rs.uns.acs.ftn.VehicleService.util.Utility;

public class ExamDTO {

    private String date;

    private String passed;

    private String student;

    private String examinar;

    private Integer ID;

    public ExamDTO() {
        super();
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

    public void setExaminar(String examinar) {
        this.examinar = examinar;
    }

    public String getDate() {
        return date;
    }

    public String getStudent() {
        return student;
    }

    public String getPassed () {
        return passed;
    }

    public String getExaminar () {
        return examinar;
    }

    public Integer getID () {
        return ID;
    }

    public void setID (Integer ID) {
        this.ID = ID;
    }

    public ExamDTO(ExamPOJO pojo) {
        this.setDate(Utility.calToStr(pojo.getDate()));
        this.setID(pojo.getID());
        this.setExaminar(pojo.getExaminar().getUID());
        this.setPassed((pojo.isPassed()) ? ("true") : ("false"));
        this.setStudent(pojo.getStudent().getUID());
    }


}
