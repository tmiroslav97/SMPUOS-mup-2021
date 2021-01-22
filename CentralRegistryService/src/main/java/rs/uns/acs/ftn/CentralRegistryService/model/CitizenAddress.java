package rs.uns.acs.ftn.CentralRegistryService.model;

import lombok.*;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbColumnConstants;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbTableConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = DbTableConstants.CITIZEN_ADDRESS)
public class CitizenAddress {
    @EmbeddedId
    private CitizenAddressId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("citizenId")
    private Citizen citizen;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("addressId")
    private Address address;

    @Column(name = DbColumnConstants.VALID_FROM)
    private Date validFrom = new Date();

    @Column(name = DbColumnConstants.VALID_UNTIL)
    private Date validUntil;
}