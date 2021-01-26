package rs.uns.acs.ftn.HealthService.service;

import rs.uns.acs.ftn.HealthService.dto.AppointmentReportDTO;
import rs.uns.acs.ftn.HealthService.model.AppointmentReport;

public interface AppointmentReportService {
    AppointmentReport create(AppointmentReportDTO appointmentReportDTO);
}
