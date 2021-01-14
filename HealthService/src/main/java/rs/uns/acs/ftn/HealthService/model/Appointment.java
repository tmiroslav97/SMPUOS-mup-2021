package rs.uns.acs.ftn.HealthService.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Document
public class Appointment {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Date startDateTime;
    private Date endDateTime;

    public Appointment() {
    }

    public Appointment(String id, String firstName, String lastName, String email, Date startDateTime, Date endDateTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    @JsonGetter("startDateTime")
    public String getTheStartDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.format(this.startDateTime);
    }

    @JsonSetter("startDateTime")
    public void setTheStartDateTime(String date) throws ParseException {
        this.startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
    }

    @JsonGetter("endDateTime")
    public String getTheEndDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.format(this.endDateTime);
    }

    @JsonSetter("endDateTime")
    public void setTheEndDateTime(String date) throws ParseException {
        this.endDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
    }
}
