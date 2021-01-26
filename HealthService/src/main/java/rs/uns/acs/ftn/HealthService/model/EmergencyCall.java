package rs.uns.acs.ftn.HealthService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class EmergencyCall {

    @Id
    private String id;
    private String street;
    private String number;
    private String city;
    private String ambTeamID;

    public EmergencyCall() {
    }

    public EmergencyCall(String street, String number, String city, String ambTeamID) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.ambTeamID = ambTeamID;
    }

    public EmergencyCall(String id, String street, String number, String city, String ambTeamID) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.ambTeamID = ambTeamID;
    }
}
