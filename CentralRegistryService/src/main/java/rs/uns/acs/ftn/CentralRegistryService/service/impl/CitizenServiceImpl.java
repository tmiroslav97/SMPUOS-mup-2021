package rs.uns.acs.ftn.CentralRegistryService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.CentralRegistryService.exception.NotFoundException;
import rs.uns.acs.ftn.CentralRegistryService.model.Citizen;
import rs.uns.acs.ftn.CentralRegistryService.repository.CitizenRepository;
import rs.uns.acs.ftn.CentralRegistryService.service.AbstractCRUDService;
import rs.uns.acs.ftn.CentralRegistryService.service.intf.CitizenService;

import java.util.List;

@Service
public class CitizenServiceImpl extends AbstractCRUDService<Citizen, Long> implements CitizenService {

    private CitizenRepository citizenRepository;

    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository) {
        super(citizenRepository);
        this.citizenRepository = citizenRepository;
    }
}
