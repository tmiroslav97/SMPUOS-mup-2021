package rs.uns.acs.ftn.VehicleService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.VehicleService.dto.PersonDTO;
import rs.uns.acs.ftn.VehicleService.dto.RecordDTO;
import rs.uns.acs.ftn.VehicleService.dto.UIDDTO;
import rs.uns.acs.ftn.VehicleService.model.PersonPOJO;
import rs.uns.acs.ftn.VehicleService.service.PersonService;
import rs.uns.acs.ftn.VehicleService.util.Utility;

import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/person/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "hello", produces = "text/html")
    public String hello() {
        System.out.println("********************************************************************************");
        System.out.println("* Neko me nadje");
        System.out.println("********************************************************************************");
        return String.format("<html>" + "<head>" + "<title>TEST</title>" + "</head>" + "<body>" + "<h1>%s</h1>"
                + "</body>" + "</html>", "VehicleService, person controller");
    }

    @RequestMapping(value = "people", produces = MediaType.APPLICATION_JSON)
    public ArrayList<PersonDTO> getPersons () {
        return personService.getPersons();
    }

    @RequestMapping(value = "addStudent", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON,
                method = RequestMethod.POST)
    public ResponseEntity<String> addStudent(@RequestBody PersonDTO p) {
        String retVal = personService.signIn(p);
        return new ResponseEntity<String>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "makeInstructor", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON,
                method = RequestMethod.PUT)
    public ResponseEntity<String> makeInstructor (@RequestBody UIDDTO UID) {
        String retVal = personService.makeInstructor(UID.getUID());
        return new ResponseEntity<String>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "record", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON,
                method = RequestMethod.GET)
    public ResponseEntity<RecordDTO> getRecord (@RequestBody UIDDTO UID) {
        RecordDTO retVal = personService.getRecord(UID.getUID());
        return new ResponseEntity<RecordDTO>(retVal, HttpStatus.OK);
    }



}
