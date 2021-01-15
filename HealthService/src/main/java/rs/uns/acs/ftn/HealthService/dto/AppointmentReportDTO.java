package rs.uns.acs.ftn.HealthService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentReportDTO {
    private String doctorId;
    private String appointmentId;
    private String diagnose;
    private Boolean passed;
}
