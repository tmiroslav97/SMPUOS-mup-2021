package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;
import rs.uns.acs.ftn.HealthService.model.enumeration.AppointmentRequestStatusEnum;
import rs.uns.acs.ftn.HealthService.repository.AppointmentRequestRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.AppointmentRequestService;

import java.util.List;

@Service
public class AppointmentRequestServiceImpl extends AbstractCRUDService<AppointmentRequest, String> implements AppointmentRequestService {

    private AppointmentRequestRepository appointmentRequestRepository;

    @Autowired
    public AppointmentRequestServiceImpl(AppointmentRequestRepository appointmentRequestRepository) {
        super(appointmentRequestRepository);
        this.appointmentRequestRepository = appointmentRequestRepository;
    }

    @Override
    public AppointmentRequest save(AppointmentRequest appointmentRequest) {
        if (appointmentRequest.getAppointmentRequestStatusEnum() == null) {
            appointmentRequest.setAppointmentRequestStatusEnum(AppointmentRequestStatusEnum.PENDING);
        }
        return appointmentRequestRepository.save(appointmentRequest);
    }

    @Override
    public List<AppointmentRequest> save(List<AppointmentRequest> appointmentRequests) {
        appointmentRequests.forEach(iter -> {
            if (iter.getAppointmentRequestStatusEnum() == null) {
                iter.setAppointmentRequestStatusEnum(AppointmentRequestStatusEnum.PENDING);
            }
        });
        return appointmentRequestRepository.saveAll(appointmentRequests);
    }
}
