package rs.uns.acs.ftn.CentralRegistryService.model;

import lombok.*;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbTableConstants;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Embeddable
public class CitizenAddressId implements Serializable {

    @Column(name = DbTableConstants.CITIZEN)
    private Long citizenId;

    @Column(name = DbTableConstants.ADDRESS)
    private Long addressId;

}
