package rs.uns.acs.ftn.HealthService.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
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

    @JsonGetter("date")
    public String getTheDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(this.date);
    }

    @JsonSetter("date")
    public void setTheDate(String date) throws ParseException {
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
