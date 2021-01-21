package rs.uns.acs.ftn.VehicleService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.VehicleService.model.LicencePOJO;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface LicenceRepository extends JpaRepository<LicencePOJO, Integer> {

    @Query(value = "SELECT * FROM licences WHERE holder_id = ?1", nativeQuery = true)
    List<LicencePOJO> getByID (Integer holder_id);

}
