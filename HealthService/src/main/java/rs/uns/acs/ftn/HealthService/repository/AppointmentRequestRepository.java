package rs.uns.acs.ftn.HealthService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;

@Repository
public interface AppointmentRequestRepository extends MongoRepository<AppointmentRequest, String> {
}
