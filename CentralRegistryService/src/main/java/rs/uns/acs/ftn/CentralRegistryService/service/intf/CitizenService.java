package rs.uns.acs.ftn.CentralRegistryService.service.intf;

import org.springframework.stereotype.Service;
import rs.uns.acs.ftn.CentralRegistryService.dto.CitizenExistsDto;
import rs.uns.acs.ftn.CentralRegistryService.dto.CitizenRequestDto;
import rs.uns.acs.ftn.CentralRegistryService.model.Citizen;
import java.util.List;

public interface CitizenService {
    Citizen changeCitizenData(Long id, CitizenRequestDto citizen);
    boolean find(CitizenExistsDto citizenExistsDto);
}
