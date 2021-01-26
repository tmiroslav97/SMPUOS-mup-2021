package rs.uns.acs.ftn.VehicleService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.VehicleService.model.ExamPOJO;

@Repository
public interface ExamRepository extends JpaRepository<ExamPOJO, Integer> {



}
