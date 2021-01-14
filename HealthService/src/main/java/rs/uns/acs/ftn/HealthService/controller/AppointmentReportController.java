package rs.uns.acs.ftn.HealthService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.HealthService.model.AppointmentReport;
import rs.uns.acs.ftn.HealthService.service.AppointmentReportService;
import rs.uns.acs.ftn.HealthService.service.impl.AppointmentReportServiceImpl;

@RestController
@RequestMapping(value = "/app-rep")
public class AppointmentReportController extends AbstractRESTController<AppointmentReport, String> {

    private AppointmentReportService appointmentReportService;

    public AppointmentReportController(AppointmentReportServiceImpl appointmentReportServiceImpl) {
        super(appointmentReportServiceImpl);
        this.appointmentReportService = appointmentReportServiceImpl;
    }
}
