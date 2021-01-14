package rs.uns.acs.ftn.HealthService.service;

import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;
import rs.uns.acs.ftn.HealthService.model.enumeration.AppointmentRequestStatusEnum;

import java.util.List;

public interface AppointmentRequestService {
    List<AppointmentRequest> findAllByAppointmentRequestStatusEnum(String appointmentRequestStatusEnum);
    Boolean rejectAppointmentRequest(String id);
}
