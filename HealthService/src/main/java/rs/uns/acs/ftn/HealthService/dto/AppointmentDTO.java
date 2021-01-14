package rs.uns.acs.ftn.HealthService.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private String doctorId;
    private String appReqId;
    private Date startDateTime;
    private Date endDateTime;

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
