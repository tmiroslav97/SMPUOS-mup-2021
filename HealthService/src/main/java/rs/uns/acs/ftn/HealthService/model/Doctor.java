package rs.uns.acs.ftn.HealthService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = RoleEnum.ROLE_DOCTOR;
    }

    public Doctor(String id, String firstName, String lastName, String email, String password, RoleEnum roleEnum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = roleEnum;
    }

}