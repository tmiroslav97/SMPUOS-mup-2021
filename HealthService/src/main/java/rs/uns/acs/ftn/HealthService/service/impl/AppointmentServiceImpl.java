package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import rs.uns.acs.ftn.HealthService.model.Appointment;
import rs.uns.acs.ftn.HealthService.repository.AppointmentRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.AppointmentService;

public class AppointmentServiceImpl extends AbstractCRUDService<Appointment, String> implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        super(appointmentRepository);
        this.appointmentRepository = appointmentRepository;
    }
}