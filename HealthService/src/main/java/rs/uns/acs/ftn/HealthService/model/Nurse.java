package rs.uns.acs.ftn.HealthService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import rs.uns.acs.ftn.HealthService.model.enumeration.RoleEnum;

@Setter
@Getter
@Document
public class Nurse {

    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String password;
    private String firstName;
    private String lastName;
    private RoleEnum role;

    public Nurse() {
    }

    public Nurse(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = RoleEnum.ROLE_NURSE;
    }

    public Nurse(String id, String firstName, String lastName, String email, String password, RoleEnum roleEnum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = roleEnum;
    }

}
