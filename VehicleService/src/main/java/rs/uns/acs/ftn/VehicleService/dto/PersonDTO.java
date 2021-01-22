package rs.uns.acs.ftn.VehicleService.dto;

import rs.uns.acs.ftn.VehicleService.model.PersonPOJO;
import rs.uns.acs.ftn.VehicleService.model.enums.RoleEnum;
import rs.uns.acs.ftn.VehicleService.util.Utility;

import java.util.Calendar;
import java.util.Date;

public class PersonDTO {

    private String fName;

    private String lName;

    private RoleEnum role;

    private String birthday;

    private String UID;

    public PersonDTO (String fName, String lName, RoleEnum role, String UID) {
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        this.birthday = "";
        this.UID = UID;
    }

    public PersonDTO(PersonPOJO p) {
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.role = p.getRole();
        this.birthday = Utility.calToStr(p.getBirthday());
        this.UID = p.getUID();
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {return this.birthday;}

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUID() {
        return UID;
    }
}
