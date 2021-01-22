package rs.uns.acs.ftn.CentralRegistryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.CentralRegistryService.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    boolean existsByUidAndNameAndSurnameAndFathersName(String uid, String name, String surname, String fathersName);
}
