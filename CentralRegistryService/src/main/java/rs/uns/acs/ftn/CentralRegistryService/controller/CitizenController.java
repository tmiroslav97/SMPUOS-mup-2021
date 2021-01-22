package rs.uns.acs.ftn.CentralRegistryService.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import rs.uns.acs.ftn.CentralRegistryService.dto.CitizenExistsDto;
import rs.uns.acs.ftn.CentralRegistryService.dto.CitizenRequestDto;
import rs.uns.acs.ftn.CentralRegistryService.model.Citizen;
import rs.uns.acs.ftn.CentralRegistryService.model.Journal;
import rs.uns.acs.ftn.CentralRegistryService.service.impl.CitizenServiceImpl;
import rs.uns.acs.ftn.CentralRegistryService.service.impl.JournalServiceImpl;
import rs.uns.acs.ftn.CentralRegistryService.service.intf.CitizenService;
import rs.uns.acs.ftn.CentralRegistryService.service.intf.JournalService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/citizen")
public class CitizenController extends AbstractRESTController<Citizen, Long>{

    private CitizenService citizenService;
    private JournalService journalService;

    public CitizenController(CitizenServiceImpl citizenService, JournalServiceImpl journalService) {
        super(citizenService);
        this.citizenService = citizenService;
        this.journalService = journalService;
    }

    @RequestMapping(value = "/changeData/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> changeData(@RequestBody CitizenRequestDto citizenRequestDto,
                                          @PathVariable("id") Long id) {
        journalService.create(id);
        Citizen updated = citizenService.changeCitizenData(id, citizenRequestDto);

        Map<String, Object> m = new HashMap<String, Object>();
        if (updated == null) {
            m.put("success", false);
        } else {
            m.put("success", true);
            m.put("updated", updated);
        }
        return m;
    }

    @RequestMapping(value = "/exists", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> citizenExists(@RequestBody CitizenExistsDto citizenExistsDto) {
        return ResponseEntity.ok(citizenService.find(citizenExistsDto));
    }

}