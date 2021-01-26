package rs.uns.acs.ftn.HealthService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.HealthService.model.Nurse;

@Repository
public interface NurseRepository extends MongoRepository<Nurse, String> {
}
