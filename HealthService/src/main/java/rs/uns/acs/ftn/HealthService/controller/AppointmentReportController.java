package rs.uns.acs.ftn.HealthService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.HealthService.dto.AppointmentReportDTO;
import rs.uns.acs.ftn.HealthService.model.AppointmentReport;
import rs.uns.acs.ftn.HealthService.service.AppointmentReportService;
import rs.uns.acs.ftn.HealthService.service.impl.AppointmentReportServiceImpl;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/app-rep")
public class AppointmentReportController extends AbstractRESTController<AppointmentReport, String> {
    private Logger logger = LoggerFactory.getLogger(AppointmentReportController.class);

    private AppointmentReportService appointmentReportService;

    public AppointmentReportController(AppointmentReportServiceImpl appointmentReportServiceImpl) {
        super(appointmentReportServiceImpl);
        this.appointmentReportService = appointmentReportServiceImpl;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> create(@RequestBody AppointmentReportDTO newEntity) {
        logger.debug("create() - {} - {}", newEntity, newEntity.getClass());

        AppointmentReport created = appointmentReportService.create(newEntity);
        Map<String, Object> m = new HashMap<String, Object>();
        if (created == null) {
            m.put("success", false);
        } else {
            m.put("success", true);
            m.put("created", created);
        }
        return m;
    }
}
