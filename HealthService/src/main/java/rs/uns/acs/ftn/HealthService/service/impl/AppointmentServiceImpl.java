package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.dto.AppointmentDTO;
import rs.uns.acs.ftn.HealthService.model.Appointment;
import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;
import rs.uns.acs.ftn.HealthService.model.Doctor;
import rs.uns.acs.ftn.HealthService.model.enumeration.AppointmentRequestStatusEnum;
import rs.uns.acs.ftn.HealthService.repository.AppointmentRepository;
import rs.uns.acs.ftn.HealthService.service.AbstractCRUDService;
import rs.uns.acs.ftn.HealthService.service.AppointmentRequestService;
import rs.uns.acs.ftn.HealthService.service.AppointmentService;
import rs.uns.acs.ftn.HealthService.service.DoctorService;

@Service
public class AppointmentServiceImpl extends AbstractCRUDService<Appointment, String> implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentRequestService appointmentRequestService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        super(appointmentRepository);
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment create(AppointmentDTO newEntity) {

        AppointmentRequest appointmentRequest = appointmentRequestService.findById(newEntity.getAppReqId());
        Doctor doctor = doctorService.findById(newEntity.getDoctorId());

        if (appointmentRequest == null || doctor == null || newEntity.getStartDateTime() == null || newEntity.getEndDateTime() == null) {
            return null;
        }

        if (appointmentRequest.getAppointmentRequestStatusEnum() != AppointmentRequestStatusEnum.PENDING) {
            return null;
        }

        Integer count = appointmentRepository.count(newEntity.getStartDateTime(), newEntity.getEndDateTime(), doctor.getId());

        if (count != 0) {
            return null;
        }

        Appointment appointment = new Appointment();
        appointment.setEmail(appointmentRequest.getEmail());
        appointment.setFirstName(appointmentRequest.getFirstName());
        appointment.setLastName(appointmentRequest.getLastName());
        appointment.setStartDateTime(newEntity.getStartDateTime());
        appointment.setEndDateTime(newEntity.getEndDateTime());
        appointment.setDoctorId(doctor.getId());
        appointment = appointmentRepository.save(appointment);
        appointmentRequest.setAppointmentRequestStatusEnum(AppointmentRequestStatusEnum.ACCEPTED);
        appointmentRequestService.saveAppointmentRequest(appointmentRequest);
        doctor.getAppointments().add(appointment);
        doctorService.saveDoctor(doctor);

        return appointment;
    }
}
