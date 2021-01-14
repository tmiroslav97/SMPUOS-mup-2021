package rs.uns.acs.ftn.HealthService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.HealthService.model.Appointment;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    @Query(value = "{$and : [{'doctorId' : { $eq: ?2}}, {'startDateTime' : { $lte : ?1}}, {'endDateTime' :{$gte : ?0}}]}", count = true)
    Integer count(Date startDateIme, Date endDateTime, String doctorId);

    List<Appointment> findAllByDoctorId(String doctorId);

    List<Appointment> findAllByDoctorIdAndStartDateTimeBetween(String doctorId, Date startDate, Date endDate);
}
