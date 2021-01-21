package rs.uns.acs.ftn.CentralRegistryService.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import rs.uns.acs.ftn.CentralRegistryService.model.Citizen;
import rs.uns.acs.ftn.CentralRegistryService.service.impl.CitizenServiceImpl;
import rs.uns.acs.ftn.CentralRegistryService.service.intf.CitizenService;

@RestController
@RequestMapping(value = "/citizen")
public class CitizenController extends AbstractRESTController<Citizen, Long>{

    private CitizenService citizenService;

    public CitizenController(CitizenServiceImpl citizenService) {
        super(citizenService);
        this.citizenService = citizenService;
    }
}