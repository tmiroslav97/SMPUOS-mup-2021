package rs.uns.acs.ftn.HealthService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;
import rs.uns.acs.ftn.HealthService.model.enumeration.AppointmentRequestStatusEnum;
import rs.uns.acs.ftn.HealthService.service.AppointmentRequestService;
import rs.uns.acs.ftn.HealthService.service.impl.AppointmentRequestServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/app-req")
public class AppointmentRequestController extends AbstractRESTController<AppointmentRequest, String> {

    private AppointmentRequestService appointmentRequestService;

    public AppointmentRequestController(AppointmentRequestServiceImpl appointmentRequestServiceImpl) {
        super(appointmentRequestServiceImpl);
        this.appointmentRequestService = appointmentRequestServiceImpl;
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public Map<String, Object> findAllByAppointmentRequestStatusEnum(@PathVariable String status) {
        List<AppointmentRequest> all = appointmentRequestService.findAllByAppointmentRequestStatusEnum(status);

        return prepareList(all);
    }

    @RequestMapping(value = "/{id}/reject", method = RequestMethod.PUT)
    public Map<String, Object> rejectAppointmentRequest(@PathVariable String id) {
        Boolean succ = appointmentRequestService.rejectAppointmentRequest(id);
        Map<String, Object> m = new HashMap<>();
        m.put("success", succ);
        return m;
    }
}
