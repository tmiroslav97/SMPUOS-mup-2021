package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.dto.AppointmentReportDTO;
import rs.uns.acs.ftn.HealthService.model.Appointment;
import rs.uns.acs.ftn.HealthService.model.AppointmentReport;
import rs.uns.acs.ftn.HealthService.model.Doctor;
import rs.uns.acs.ftn.HealthService.repository.AppointmentReportRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.AppointmentReportService;
import rs.uns.acs.ftn.HealthService.service.AppointmentService;
import rs.uns.acs.ftn.HealthService.service.DoctorService;

@Service
public class AppointmentReportServiceImpl extends AbstractCRUDService<AppointmentReport, String> implements AppointmentReportService {

    private AppointmentReportRepository appointmentReportRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    public AppointmentReportServiceImpl(AppointmentReportRepository appointmentReportRepository) {
        super(appointmentReportRepository);
        this.appointmentReportRepository = appointmentReportRepository;
    }

    @Override
    public AppointmentReport create(AppointmentReportDTO appointmentReportDTO) {
        Doctor doctor = doctorService.findById(appointmentReportDTO.getDoctorId());
        Appointment appointment = appointmentService.findById(appointmentReportDTO.getAppointmentId());

        if (doctor == null || appointment == null) {
            return null;
        }

        AppointmentReport appointmentReport = new AppointmentReport();
        appointmentReport.setAppointmentId(appointment.getId());
        appointmentReport.setDoctorFirstName(doctor.getFirstName());
        appointmentReport.setDoctorLastName(doctor.getLastName());
        appointmentReport.setDiagnose(appointmentReportDTO.getDiagnose());
        appointmentReport.setPassed(appointmentReportDTO.getPassed());
        appointmentReport.setFirstName(appointment.getFirstName());
        appointmentReport.setLastName(appointment.getLastName());
        appointmentReport.setEmail(appointment.getEmail());
        appointmentReport = appointmentReportRepository.save(appointmentReport);

        return appointmentReport;
    }
}
