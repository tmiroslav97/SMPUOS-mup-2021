package rs.uns.acs.ftn.CentralRegistryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.uns.acs.ftn.CentralRegistryService.model.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
