package rs.uns.acs.ftn.VehicleService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.VehicleService.dto.LicenceDTO;
import rs.uns.acs.ftn.VehicleService.service.LicenceService;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/licence/")
public class LicenceController {

    @Autowired
    private LicenceService licenceService;

    @RequestMapping(value = "hello", produces = "text/html")
    public String hello() {
        System.out.println("********************************************************************************");
        System.out.println("* Neko me nadje");
        System.out.println("********************************************************************************");
        return String.format("<html>" + "<head>" + "<title>TEST</title>" + "</head>" + "<body>" + "<h1>%s</h1>"
                + "</body>" + "</html>", "VehicleService, licence controller");
    }

    @RequestMapping(value = "getAll", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<List<LicenceDTO>> getLicences () {
        List<LicenceDTO> retVal = licenceService.getLicences();
        return new ResponseEntity<List<LicenceDTO>>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "add", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON,
                method = RequestMethod.PUT)
    public ResponseEntity<String> addLicence (@RequestBody LicenceDTO dto) {
        String retVal = licenceService.add(dto);
        return new ResponseEntity<String>(retVal, HttpStatus.OK);
    }



}
