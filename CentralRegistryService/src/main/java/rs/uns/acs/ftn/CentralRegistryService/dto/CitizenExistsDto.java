package rs.uns.acs.ftn.CentralRegistryService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenExistsDto {
    private String uid;
    private String name;
    private String surname;
    private String fathersName;
}
