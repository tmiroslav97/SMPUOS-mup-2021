package rs.uns.acs.ftn.HealthService.service;

import rs.uns.acs.ftn.HealthService.dto.AppointmentDTO;
import rs.uns.acs.ftn.HealthService.model.Appointment;

public interface AppointmentService {
    Appointment create(AppointmentDTO newEntity);
}
