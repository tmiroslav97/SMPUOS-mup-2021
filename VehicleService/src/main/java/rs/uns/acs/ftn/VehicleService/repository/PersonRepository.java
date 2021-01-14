package rs.uns.acs.ftn.VehicleService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.VehicleService.model.PersonPOJO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

@Repository
public interface PersonRepository extends JpaRepository<PersonPOJO, Integer> {

    @Query(value = "SELECT COUNT(*) FROM persons WHERE UID LIKE ?1", nativeQuery = true)
    Integer countByUID(String UID);

    @Query(value = "SELECT * FROM persons WHERE UID = ?1", nativeQuery = true)
    ArrayList<PersonPOJO> getPersonByUID(String UID);

}






/*
*   @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
  User findByEmailAddress(String emailAddress);
* */