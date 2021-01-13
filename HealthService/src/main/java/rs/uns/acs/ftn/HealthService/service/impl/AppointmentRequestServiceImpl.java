package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;
import rs.uns.acs.ftn.HealthService.repository.AppointmentRequestRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.AppointmentRequestService;

@Service
public class AppointmentRequestServiceImpl extends AbstractCRUDService<AppointmentRequest, String> implements AppointmentRequestService {

    private AppointmentRequestRepository appointmentRequestRepository;

    @Autowired
    public AppointmentRequestServiceImpl(AppointmentRequestRepository appointmentRequestRepository) {
        super(appointmentRequestRepository);
        this.appointmentRequestRepository = appointmentRequestRepository;
    }
}
