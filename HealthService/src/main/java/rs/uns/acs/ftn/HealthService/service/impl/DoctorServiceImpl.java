package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.model.Doctor;
import rs.uns.acs.ftn.HealthService.repository.DoctorRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.DoctorService;

@Service
public class DoctorServiceImpl extends AbstractCRUDService<Doctor, String> implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        super(doctorRepository);
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findById(String id) {
        return this.findOne(id);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return this.save(doctor);
    }
}
