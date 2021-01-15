package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.model.Ambulance;
import rs.uns.acs.ftn.HealthService.repository.AmbulanceRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.AmbulanceService;

@Service
public class AmbulanceServiceImpl extends AbstractCRUDService<Ambulance, String> implements AmbulanceService {

    private AmbulanceRepository ambulanceRepository;

    @Autowired
    public AmbulanceServiceImpl(AmbulanceRepository ambulanceRepository) {
        super(ambulanceRepository);
        this.ambulanceRepository = ambulanceRepository;
    }
}
