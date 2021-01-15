package rs.uns.acs.ftn.HealthService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.HealthService.model.Doctor;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
