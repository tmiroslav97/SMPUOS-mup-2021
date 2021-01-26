package rs.uns.acs.ftn.VehicleService.model;

import rs.uns.acs.ftn.VehicleService.dto.PersonDTO;
import rs.uns.acs.ftn.VehicleService.model.enums.RoleEnum;
import rs.uns.acs.ftn.VehicleService.util.Utility;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "persons")
public class PersonPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "first_name", nullable = false)
    private String fName;

    @Column(name = "last_name", nullable = false)
    private String lName;

    @Column(name = "UID", nullable = false)
    private String UID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_date", nullable = false)
    private Calendar birthday;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleEnum role;

    @OneToMany(mappedBy = "holder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LicencePOJO> licences;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LessonPOJO> lessonsGiven;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LessonPOJO> lessonsTaken;

    @OneToMany(mappedBy = "examinar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExamPOJO> examsGiven;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExamPOJO> examsTaken;

    public PersonPOJO(String fName, String lName, String uid, Calendar birthday, RoleEnum role) {
        this.fName = fName;
        this.lName = lName;
        UID = uid;
        this.birthday = birthday;
        this.role = role;
    }

    public PersonPOJO () {
        super();
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setExamsGiven(List<ExamPOJO> examsGiven) {
        this.examsGiven = examsGiven;
    }

    public void setExamsTaken(List<ExamPOJO> examsTaken) {
        this.examsTaken = examsTaken;
    }

    public void setLessonsGiven(List<LessonPOJO> lessonsGiven) {
        this.lessonsGiven = lessonsGiven;
    }

    public void setLessonsTaken(List<LessonPOJO> lessonsTaken) {
        this.lessonsTaken = lessonsTaken;
    }

    public List<ExamPOJO> getExamsGiven() {
        return examsGiven;
    }

    public List<ExamPOJO> getExamsTaken() {
        return examsTaken;
    }

    public List<LessonPOJO> getLessonsGiven() {
        return lessonsGiven;
    }

    public List<LessonPOJO> getLessonsTaken() {
        return lessonsTaken;
    }

    public List<LicencePOJO> getLicences() {
        return licences;
    }

    public void setLicences(List<LicencePOJO> licences) {
        this.licences = licences;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName () {
        return lName;
    }

    public void setlName(String lName) {
        this.fName = lName;
    }

    public String getUID () {
        return UID;
    }

    public void setUID (String UID) {
        this.UID = UID;
    }

    public void setBirthday (Calendar birthday) {
        this.birthday = birthday;
    }

    public Calendar getBirthday () {
        return birthday;
    }

    public void setRole (RoleEnum role) {
        this.role = role;
    }

    public RoleEnum getRole () {
        return role;
    }

    public PersonPOJO (PersonDTO p) {
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.UID = p.getUID();
        this.role = p.getRole();
        this.birthday = Utility.strToCal(p.getBirthday());
    }

}
