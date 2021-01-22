package rs.uns.acs.ftn.CentralRegistryService.service.intf;

import rs.uns.acs.ftn.CentralRegistryService.model.Journal;

public interface JournalService {
    Journal create(Long citizenId);
}
