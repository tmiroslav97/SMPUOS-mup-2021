package rs.uns.acs.ftn.HealthService.service;

import rs.uns.acs.ftn.HealthService.dto.EmailDTO;

public interface EmailService {
    void sendMailTo(EmailDTO emailDTO);
}
