package rs.uns.acs.ftn.CentralRegistryService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenRequestDto {

    private String name;

    private String surname;

    private String fathersName;

}
