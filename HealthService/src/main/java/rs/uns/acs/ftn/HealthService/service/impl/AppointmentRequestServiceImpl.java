package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;
import rs.uns.acs.ftn.HealthService.model.enumeration.AppointmentRequestStatusEnum;
import rs.uns.acs.ftn.HealthService.repository.AppointmentRequestRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.AppointmentRequestService;

import java.sql.Date;
import java.util.ArrayList;
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
        if (appointmentRequest.getEmail() == null || appointmentRequest.getDate().before(Date.valueOf(java.time.LocalDate.now()))) {
            return null;
        }
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

    @Override
    public List<AppointmentRequest> findAllByAppointmentRequestStatusEnum(String status) {
        AppointmentRequestStatusEnum appointmentRequestStatusEnum = null;
        switch (status) {
            case "pending":
                appointmentRequestStatusEnum = AppointmentRequestStatusEnum.PENDING;
                break;
            case "accepted":
                appointmentRequestStatusEnum = AppointmentRequestStatusEnum.ACCEPTED;
                break;
            case "rejected":
                appointmentRequestStatusEnum = AppointmentRequestStatusEnum.REJECTED;
                break;
            default:
                return new ArrayList<>();
        }
        return appointmentRequestRepository.findAllByAppointmentRequestStatusEnum(appointmentRequestStatusEnum);
    }

    @Override
    public Boolean rejectAppointmentRequest(String id) {
        AppointmentRequest appointmentRequest = this.findOne(id);
        if (appointmentRequest == null) {
            return false;
        }
        if (appointmentRequest.getAppointmentRequestStatusEnum() == AppointmentRequestStatusEnum.PENDING) {
            appointmentRequest.setAppointmentRequestStatusEnum(AppointmentRequestStatusEnum.REJECTED);
            this.save(appointmentRequest);
            return true;
        } else {
            return false;
        }
    }
}
