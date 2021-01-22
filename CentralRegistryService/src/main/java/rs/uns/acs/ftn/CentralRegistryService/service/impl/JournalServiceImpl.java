package rs.uns.acs.ftn.CentralRegistryService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.CentralRegistryService.model.Citizen;
import rs.uns.acs.ftn.CentralRegistryService.model.Journal;
import rs.uns.acs.ftn.CentralRegistryService.repository.CitizenRepository;
import rs.uns.acs.ftn.CentralRegistryService.repository.JournalRepository;
import rs.uns.acs.ftn.CentralRegistryService.service.AbstractCRUDService;
import rs.uns.acs.ftn.CentralRegistryService.service.intf.JournalService;

import javax.persistence.EntityNotFoundException;

@Service
public class JournalServiceImpl extends AbstractCRUDService<Journal, Long> implements JournalService {

    private JournalRepository journalRepository;
    private CitizenRepository citizenRepository;

    @Autowired
    public JournalServiceImpl(JournalRepository journalRepository, CitizenRepository citizenRepository) {
        super(journalRepository);
        this.journalRepository = journalRepository;
        this.citizenRepository = citizenRepository;
    }

    @Override
    public Journal create(Long citizenId) {
        Citizen citizen = citizenRepository.findById(citizenId).orElseThrow(() -> new EntityNotFoundException("Gradjanin nije pronadjen"));
        Journal journal = new Journal();

        journal.setName(citizen.getName());
        journal.setSurname(citizen.getSurname());
        journal.setFathersName(citizen.getFathersName());
        journal.setCitizen(citizen);

        return journalRepository.save(journal);
    }
}
