package rs.uns.acs.ftn.VehicleService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.VehicleService.dto.TicketDTO;
import rs.uns.acs.ftn.VehicleService.service.TicketService;

import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/tickets/")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "getAll", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<ArrayList<TicketDTO>> getTickets() {
        ArrayList<TicketDTO> retVal = ticketService.getTickets();
        return new ResponseEntity<ArrayList<TicketDTO>>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "add", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON,
                    method = RequestMethod.PUT)
    public ResponseEntity<String> addTicket (@RequestBody TicketDTO dto) {
        String retVal = ticketService.addTicket(dto);
        return new ResponseEntity<String>(retVal, HttpStatus.OK);
    }




}
