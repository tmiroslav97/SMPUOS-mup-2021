package rs.uns.acs.ftn.CentralRegistryService.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = DbTableConstants.JOURNAL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = DbColumnConstants.NAME, nullable = false)
    private String name;

    @Column(name = DbColumnConstants.SURNAME, nullable = false)
    private String surname;

    @Column(name = DbColumnConstants.FATHERS_NAME, nullable = false)
    private String fathersName;

    @Column(name = DbColumnConstants.VALID_FROM, nullable = false)
    private java.util.Date validFrom = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    private Citizen citizen;
}
