package rs.uns.acs.ftn.VehicleService.model;

import rs.uns.acs.ftn.VehicleService.dto.AddLessonDTO;
import rs.uns.acs.ftn.VehicleService.model.enums.SubjectEnum;
import rs.uns.acs.ftn.VehicleService.repository.PersonRepository;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "lessons")
public class LessonPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datee")
    private Calendar date;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject", nullable = false)
    private SubjectEnum subject;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonPOJO student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonPOJO instructor;

    public LessonPOJO(Calendar date, SubjectEnum subject, PersonPOJO student, PersonPOJO instructor) {
        this.date = date;
        this.subject = subject;
        this.student = student;
        this.instructor = instructor;
    }

    public LessonPOJO () {
        super();
    }

    public void setID (Integer ID) {
        this.ID = ID;
    }

    public Integer getID () {
        return ID;
    }

    public void setDate (Calendar date) {
        this.date = date;
    }

    public Calendar getDate() {
        return date;
    }

    public void setSubject(SubjectEnum subject) {
        this.subject = subject;
    }

    public SubjectEnum getSubject() {
        return subject;
    }

    public void setStudent (PersonPOJO student) {
        this.student = student;
    }

    public PersonPOJO getStudent () {
        return student;
    }

    public void setInstructor (PersonPOJO instructor) {
        this.instructor = instructor;
    }

    public PersonPOJO getInstructor () {
        return instructor;
    }

}
