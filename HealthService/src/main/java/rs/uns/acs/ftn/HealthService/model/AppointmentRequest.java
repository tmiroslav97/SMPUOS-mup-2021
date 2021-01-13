package rs.uns.acs.ftn.HealthService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class AppointmentRequest {

    @Id
    private String id;
    @Indexed
    private String firstName;
    private String lastName;
    private String email;
    private Date date;

    public AppointmentRequest() {
    }

    public AppointmentRequest(String firstName, String lastName, String email, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date = date;
    }

    public AppointmentRequest(String id, String firstName, String lastName, String email, Date date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date = date;
    }
}
