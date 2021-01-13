package rs.uns.acs.ftn.HealthService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;
import rs.uns.acs.ftn.HealthService.service.AppointmentRequestService;
import rs.uns.acs.ftn.HealthService.service.impl.AppointmentRequestServiceImpl;

@RestController
@RequestMapping(value = "/app-req")
public class AppointmentRequestController extends AbstractRESTController<AppointmentRequest, String> {

    private AppointmentRequestService appointmentRequestService;

    public AppointmentRequestController(AppointmentRequestServiceImpl appointmentRequestServiceImpl) {
        super(appointmentRequestServiceImpl);
        this.appointmentRequestService = appointmentRequestServiceImpl;
    }
}
