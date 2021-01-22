package rs.uns.acs.ftn.CentralRegistryService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.CentralRegistryService.dto.CitizenExistsDto;
import rs.uns.acs.ftn.CentralRegistryService.dto.CitizenRequestDto;
import rs.uns.acs.ftn.CentralRegistryService.exception.NotFoundException;
import rs.uns.acs.ftn.CentralRegistryService.model.Citizen;
import rs.uns.acs.ftn.CentralRegistryService.model.Journal;
import rs.uns.acs.ftn.CentralRegistryService.repository.CitizenRepository;
import rs.uns.acs.ftn.CentralRegistryService.repository.JournalRepository;
import rs.uns.acs.ftn.CentralRegistryService.service.AbstractCRUDService;
import rs.uns.acs.ftn.CentralRegistryService.service.intf.CitizenService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CitizenServiceImpl extends AbstractCRUDService<Citizen, Long> implements CitizenService {

    private CitizenRepository citizenRepository;

    private JournalRepository journalRepository;

    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository, JournalRepository journalRepository) {
        super(citizenRepository);
        this.citizenRepository = citizenRepository;
        this.journalRepository = journalRepository;
    }

    @Override
    public Citizen changeCitizenData(Long id, CitizenRequestDto citizen) {
        Citizen oldCitizen = citizenRepository.getOne(id);

        oldCitizen.setName(citizen.getName());
        oldCitizen.setSurname(citizen.getSurname());
        oldCitizen.setFathersName(citizen.getFathersName());

        return citizenRepository.save(oldCitizen);
    }

    @Override
    public boolean find(CitizenExistsDto citizenExistsDto)
    {
        return citizenRepository.existsByUidAndNameAndSurnameAndFathersName(citizenExistsDto.getUid(), citizenExistsDto.getName(), citizenExistsDto.getSurname(), citizenExistsDto.getFathersName());
    }
}
