package rs.uns.acs.ftn.HealthService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.HealthService.model.EmergencyCall;
import rs.uns.acs.ftn.HealthService.service.EmergencyCallService;
import rs.uns.acs.ftn.HealthService.service.impl.EmergencyCallServiceImpl;

@RestController
@RequestMapping(value = "/emr-call")
public class EmergencyCallController extends AbstractRESTController<EmergencyCall, String> {

    private EmergencyCallService emergencyCallService;

    public EmergencyCallController(EmergencyCallServiceImpl emergencyCallServiceImpl) {
        super(emergencyCallServiceImpl);
        this.emergencyCallService = emergencyCallServiceImpl;
    }
}
