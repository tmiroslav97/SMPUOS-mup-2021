package rs.uns.acs.ftn.HealthService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Nurse {

    @Id
    public String id;
    public String firstName;
    public String lastName;


}
