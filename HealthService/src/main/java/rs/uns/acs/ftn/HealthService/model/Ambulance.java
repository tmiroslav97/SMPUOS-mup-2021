package rs.uns.acs.ftn.HealthService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Ambulance {

    @Id
    private String id;
    private String teamName;
    private AmbStatusEnum ambStatusEnum;

    public Ambulance() {
    }

    public Ambulance(String teamName, AmbStatusEnum ambStatusEnum) {
        this.teamName = teamName;
        this.ambStatusEnum = ambStatusEnum;
    }

}
