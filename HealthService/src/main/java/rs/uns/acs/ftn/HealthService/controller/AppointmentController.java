package rs.uns.acs.ftn.HealthService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rs.uns.acs.ftn.HealthService.dto.AppointmentDTO;
import rs.uns.acs.ftn.HealthService.model.Appointment;
import rs.uns.acs.ftn.HealthService.service.AppointmentService;
import rs.uns.acs.ftn.HealthService.service.impl.AppointmentServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/app")
public class AppointmentController extends AbstractRESTController<Appointment, String> {
    private Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentServiceImpl appointmentServiceImpl) {
        super(appointmentServiceImpl);
        this.appointmentService = appointmentServiceImpl;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> create(@RequestBody AppointmentDTO newEntity) {
        logger.debug("create() - {} - {}", newEntity, newEntity.getClass());

        Appointment created = appointmentService.create(newEntity);
        Map<String, Object> m = new HashMap<String, Object>();
        if (created == null) {
            m.put("success", false);
        } else {
            m.put("success", true);
            m.put("created", created);
        }
        return m;
    }

    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
    public List<Appointment> findAllByDoctorId(@PathVariable String id) {

        List<Appointment> appointments = appointmentService.findAllByDoctorId(id);
        return appointments;
    }
}
