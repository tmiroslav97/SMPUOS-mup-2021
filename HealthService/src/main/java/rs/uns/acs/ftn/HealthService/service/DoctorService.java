package rs.uns.acs.ftn.HealthService.service;

import rs.uns.acs.ftn.HealthService.model.Doctor;

public interface DoctorService {
    Doctor findById(String id);
    Doctor saveDoctor(Doctor doctor);
}
