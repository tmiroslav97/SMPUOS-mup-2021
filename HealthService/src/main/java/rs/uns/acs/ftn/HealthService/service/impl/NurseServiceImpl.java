package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.model.Nurse;
import rs.uns.acs.ftn.HealthService.repository.NurseRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.NurseService;

@Service
public class NurseServiceImpl extends AbstractCRUDService<Nurse, String> implements NurseService {

    private NurseRepository nurseRepository;

    @Autowired
    public NurseServiceImpl(NurseRepository nurseRepository) {
        super(nurseRepository);
        this.nurseRepository = nurseRepository;
    }


}
