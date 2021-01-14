package rs.uns.acs.ftn.HealthService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.HealthService.model.Appointment;
import rs.uns.acs.ftn.HealthService.service.AppointmentService;
import rs.uns.acs.ftn.HealthService.service.impl.AppointmentServiceImpl;

@RestController
@RequestMapping(value = "/app")
public class AppointmentController extends AbstractRESTController<Appointment, String> {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentServiceImpl appointmentServiceImpl) {
        super(appointmentServiceImpl);
        this.appointmentService = appointmentServiceImpl;
    }
}
