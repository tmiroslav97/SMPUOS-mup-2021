package rs.uns.acs.ftn.CentralRegistryService.model;

import lombok.*;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbColumnConstants;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbTableConstants;

import javax.persistence.*;
import java.util.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = DbTableConstants.PASSPORT)
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = DbColumnConstants.VALID_FROM, nullable = false)
    private java.util.Date validFrom;

    @Column(name = DbColumnConstants.VALID_UNTIL)
    private Date validUntil;

    @ManyToOne(fetch = FetchType.LAZY)
    private Citizen citizen;
}
