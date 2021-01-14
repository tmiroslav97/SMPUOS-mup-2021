package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.model.AppointmentReport;
import rs.uns.acs.ftn.HealthService.repository.AppointmentReportRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.AppointmentReportService;

@Service
public class AppointmentReportServiceImpl extends AbstractCRUDService<AppointmentReport, String> implements AppointmentReportService {

    private AppointmentReportRepository appointmentReportRepository;

    @Autowired
    public AppointmentReportServiceImpl(AppointmentReportRepository appointmentReportRepository) {
        super(appointmentReportRepository);
        this.appointmentReportRepository = appointmentReportRepository;
    }
}
