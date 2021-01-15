package rs.uns.acs.ftn.HealthService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    private String subject;
    private String message;
    private String reciever;
}
