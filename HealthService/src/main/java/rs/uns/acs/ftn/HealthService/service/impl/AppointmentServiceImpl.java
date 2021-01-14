package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.dto.AppointmentDTO;
import rs.uns.acs.ftn.HealthService.dto.EmailDTO;
import rs.uns.acs.ftn.HealthService.model.Appointment;
import rs.uns.acs.ftn.HealthService.model.AppointmentRequest;
import rs.uns.acs.ftn.HealthService.model.Doctor;
import rs.uns.acs.ftn.HealthService.model.enumeration.AppointmentRequestStatusEnum;
import rs.uns.acs.ftn.HealthService.repository.AppointmentRepository;
import rs.uns.acs.ftn.HealthService.service.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl extends AbstractCRUDService<Appointment, String> implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentRequestService appointmentRequestService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    EmailService emailService;

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
        appointment.setAppReqProviderEnum(appointmentRequest.getAppReqProviderEnum());
        appointment = appointmentRepository.save(appointment);
        appointmentRequest.setAppointmentRequestStatusEnum(AppointmentRequestStatusEnum.ACCEPTED);
        appointmentRequestService.saveAppointmentRequest(appointmentRequest);
        doctor.getAppointments().add(appointment);
        doctorService.saveDoctor(doctor);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String startDateTimeStr = dateFormat.format(appointment.getStartDateTime());
        String endDateTimeStr = dateFormat.format(appointment.getEndDateTime());
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setSubject("Rezervisanje termina pregleda");
        emailDTO.setReciever(appointment.getEmail());
        emailDTO.setMessage(String.format("Postovani/a,\nRezervisan vam je termin za pregled %s u periodu:\n%s-%s\nJedinstveni broj:%s", startDateTimeStr.split(" ")[0], startDateTimeStr.split(" ")[1], endDateTimeStr.split(" ")[1], appointment.getId()));
        emailService.sendMailTo(emailDTO);

        return appointment;
    }

    @Override
    public List<Appointment> findAllByDoctorId(String doctorId) {
        return appointmentRepository.findAllByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> findAllByDoctorIdAndDate(String doctorId, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.DATE, 1);
        Date endDate = c.getTime();

        return appointmentRepository.findAllByDoctorIdAndStartDateTimeBetween(doctorId, startDate, endDate);
    }
}
