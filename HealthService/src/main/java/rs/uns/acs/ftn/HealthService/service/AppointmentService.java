package rs.uns.acs.ftn.HealthService.service;

import rs.uns.acs.ftn.HealthService.dto.AppointmentDTO;
import rs.uns.acs.ftn.HealthService.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment create(AppointmentDTO newEntity);
    List<Appointment> findAllByDoctorId(String doctorId);

}
