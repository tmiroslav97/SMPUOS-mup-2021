package rs.uns.acs.ftn.VehicleService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "exams")
public class ExamPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datee", nullable = false)
    private Calendar date;

    @Column(name = "passed", nullable = false)
    private boolean passed;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonPOJO student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonPOJO examinar;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setExaminar(PersonPOJO examinar) {
        this.examinar = examinar;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public void setStudent(PersonPOJO student) {
        this.student = student;
    }

    public Calendar getDate() {
        return date;
    }

    public Integer getID() {
        return ID;
    }

    public PersonPOJO getExaminar() {
        return examinar;
    }

    public PersonPOJO getStudent() {
        return student;
    }

    public boolean isPassed() {
        return passed;
    }
}
