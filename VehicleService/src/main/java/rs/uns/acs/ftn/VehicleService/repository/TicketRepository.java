package rs.uns.acs.ftn.VehicleService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.VehicleService.model.TicketPOJO;

@Repository
public interface TicketRepository extends JpaRepository <TicketPOJO, Integer> {



}
