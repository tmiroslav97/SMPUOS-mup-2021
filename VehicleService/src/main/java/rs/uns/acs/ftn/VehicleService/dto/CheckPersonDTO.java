package rs.uns.acs.ftn.VehicleService.dto;

public class CheckPersonDTO {

    private String uid;
    private String name;
    private String surname;
    private String fathersName;

    public CheckPersonDTO () {
        super();
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUid() {
        return uid;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public CheckPersonDTO (PersonDTO dto) {
        this.fathersName = dto.getFathersName();
        this.name = dto.getfName();
        this.surname = dto.getlName();
        this.uid = dto.getUID();
    }
}
