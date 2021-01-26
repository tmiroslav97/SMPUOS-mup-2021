package rs.uns.acs.ftn.HealthService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.HealthService.model.AppointmentReport;

@Repository
public interface AppointmentReportRepository extends MongoRepository<AppointmentReport, String> {
}
