package rs.uns.acs.ftn.HealthService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.HealthService.model.Ambulance;

@Repository
public interface AmbulanceRepository extends MongoRepository<Ambulance, String> {
}
