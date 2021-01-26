package rs.uns.acs.ftn.HealthService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.HealthService.dto.EmailDTO;
import rs.uns.acs.ftn.HealthService.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Async
    @Override
    public void sendMailTo(EmailDTO emailDTO) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailDTO.getReciever());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject(emailDTO.getSubject());
        mail.setText(emailDTO.getMessage());
        javaMailSender.send(mail);
    }
}
