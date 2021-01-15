package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.model.EmergencyCall;
import rs.uns.acs.ftn.HealthService.repository.EmergencyCallRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.EmergencyCallService;

@Service
public class EmergencyCallServiceImpl extends AbstractCRUDService<EmergencyCall, String> implements EmergencyCallService {

    private EmergencyCallRepository emergencyCallRepository;

    @Autowired
    public EmergencyCallServiceImpl(EmergencyCallRepository emergencyCallRepository){
        super(emergencyCallRepository);
        this.emergencyCallRepository = emergencyCallRepository;
    }
}
