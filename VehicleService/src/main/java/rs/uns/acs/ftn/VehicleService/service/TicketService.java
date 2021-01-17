package rs.uns.acs.ftn.VehicleService.service;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.VehicleService.dto.TicketDTO;
import rs.uns.acs.ftn.VehicleService.model.LicencePOJO;
import rs.uns.acs.ftn.VehicleService.model.TicketPOJO;
import rs.uns.acs.ftn.VehicleService.repository.LicenceRepository;
import rs.uns.acs.ftn.VehicleService.repository.TicketRepository;
import rs.uns.acs.ftn.VehicleService.util.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    LicenceRepository licenceRepository;

    public ArrayList<TicketDTO> getTickets () {
        ArrayList<TicketDTO> retVal = new ArrayList<TicketDTO>();
        for (TicketPOJO t : ticketRepository.findAll()) {
            retVal.add(new TicketDTO(t));
        }
        return retVal;
    }

    public String addTicket (TicketDTO dto) {
        if (dto.getDate() == null) {
            return "Please submit a date";
        }
        if (dto.getOffense() == null) {
            return "Please submit an offense";
        }
        if (dto.getPoints() == null) {
            return "Please submit points";
        }
        if (dto.getLicence() == null) {
            return "Please submit a licence";
        }
        Optional<LicencePOJO> licence = licenceRepository.findById(dto.getLicence());
        if (!licence.isPresent()) {
            return "Please submit a VALID licence";
        }

        TicketPOJO ticket = new TicketPOJO();
        ticket.setDate(Utility.strToCal(dto.getDate()));
        ticket.setOffense(dto.getOffense());
        ticket.setPoints(dto.getPoints());
        ticket.setLicence(licence.get());
        ticketRepository.save(ticket);

        return "Ticket successfully added";
    }



}
