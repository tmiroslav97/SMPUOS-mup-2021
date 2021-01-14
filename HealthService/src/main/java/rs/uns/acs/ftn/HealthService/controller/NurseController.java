package rs.uns.acs.ftn.HealthService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.HealthService.model.Nurse;
import rs.uns.acs.ftn.HealthService.service.NurseService;
import rs.uns.acs.ftn.HealthService.service.impl.NurseServiceImpl;

@RestController
@RequestMapping(value = "/nurse")
public class NurseController extends AbstractRESTController<Nurse, String> {

    private NurseService nurseService;

    public NurseController(NurseServiceImpl nurseServiceImpl) {
        super(nurseServiceImpl);
        this.nurseService = nurseServiceImpl;
    }
}
