package rs.uns.acs.ftn.CentralRegistryService.model;

import lombok.*;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbColumnConstants;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbTableConstants;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = DbTableConstants.QUERY)
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = DbColumnConstants.EMAIL, nullable = false)
    private String email;

    @Column(name = DbColumnConstants.QUESTION, nullable = false)
    private String question;

    @Column(name = DbColumnConstants.RESPONDED)
    private Boolean responded;

    @ManyToOne(fetch = FetchType.LAZY)
    private Citizen citizen;
}
