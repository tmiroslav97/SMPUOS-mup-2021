package rs.uns.acs.ftn.VehicleService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.VehicleService.model.LessonPOJO;

@Repository
public interface LessonRepository extends JpaRepository<LessonPOJO, Integer> {



}
