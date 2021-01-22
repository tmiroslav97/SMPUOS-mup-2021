package rs.uns.acs.ftn.CentralRegistryService.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbColumnConstants;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbTableConstants;
import rs.uns.acs.ftn.CentralRegistryService.model.enumeration.Gender;
import rs.uns.acs.ftn.CentralRegistryService.model.enumeration.RequestStatus;
import rs.uns.acs.ftn.CentralRegistryService.model.enumeration.RequestType;

import javax.persistence.*;
import java.sql.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = DbTableConstants.REQUEST)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = DbColumnConstants.DATE, nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Citizen citizen;

    @Enumerated(EnumType.STRING)
    @Column(name = DbColumnConstants.REQUEST_TYPE, nullable = false)
    private RequestType requestType;

    @Enumerated(EnumType.STRING)
    @Column(name = DbColumnConstants.REQUEST_STATUS, nullable = false)
    private RequestStatus requestStatus;
}
