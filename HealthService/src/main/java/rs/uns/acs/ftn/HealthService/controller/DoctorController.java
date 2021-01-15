package rs.uns.acs.ftn.HealthService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.HealthService.model.Doctor;
import rs.uns.acs.ftn.HealthService.service.DoctorService;
import rs.uns.acs.ftn.HealthService.service.impl.DoctorServiceImpl;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController extends AbstractRESTController<Doctor, String> {

    private DoctorService doctorService;

    public DoctorController(DoctorServiceImpl doctorServiceImpl) {
        super(doctorServiceImpl);
        this.doctorService = doctorServiceImpl;
    }

}
