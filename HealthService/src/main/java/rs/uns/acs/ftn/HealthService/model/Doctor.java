package rs.uns.acs.ftn.HealthService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import rs.uns.acs.ftn.HealthService.model.enumeration.RoleEnum;

import java.util.List;

@Setter
@Getter
@Document
public class Doctor {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private RoleEnum role;
    @DBRef(lazy = true)
    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = RoleEnum.ROLE_DOCTOR;
    }


    public Doctor(String firstName, String lastName, String email, String password, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = RoleEnum.ROLE_DOCTOR;
        this.appointments = appointments;
    }

    public Doctor(String id, String firstName, String lastName, String email, String password, RoleEnum roleEnum, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = roleEnum;
        this.appointments = appointments;
    }

}
