package rs.uns.acs.ftn.HealthService.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class AppointmentReport {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String diagnose;
    private String passed;
    private String appointmentId;

    public AppointmentReport() {
    }

    public AppointmentReport(String firstName, String lastName, String email, String diagnose, String passed, String appointmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.diagnose = diagnose;
        this.passed = passed;
        this.appointmentId = appointmentId;
    }

    public AppointmentReport(String id, String firstName, String lastName, String email, String diagnose, String passed, String appointmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.diagnose = diagnose;
        this.passed = passed;
        this.appointmentId = appointmentId;
    }

}
