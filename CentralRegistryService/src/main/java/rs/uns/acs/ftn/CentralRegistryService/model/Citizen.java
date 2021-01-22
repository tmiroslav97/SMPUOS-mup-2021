package rs.uns.acs.ftn.CentralRegistryService.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbColumnConstants;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbTableConstants;
import rs.uns.acs.ftn.CentralRegistryService.model.enumeration.Gender;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = DbTableConstants.CITIZEN)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = DbColumnConstants.NAME, nullable = false)
    private String name;

    @Column(name = DbColumnConstants.SURNAME, nullable = false)
    private String surname;

    @Column(name = DbColumnConstants.UID, length = 13, unique = true, nullable = false)
    private String uid;

    @Column(name = DbColumnConstants.BIRTH_DATE, nullable = false)
    private Date birthDate;

    @Column(name = DbColumnConstants.FATHERS_NAME, nullable = false)
    private String fathersName;

    @Enumerated(EnumType.STRING)
    @Column(name = DbColumnConstants.GENDER, nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL)
    private Set<IdentificationCard> identificationCards = new HashSet<>();

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL)
    private Set<Passport> passports = new HashSet<>();

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL)
    private Set<CitizenAddress> addresses = new HashSet<>();

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL )
    private Set<Journal> journal = new HashSet<>();

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL )
    private Set<Query> queries = new HashSet<>();

    @OneToMany(mappedBy = "citizen",
            cascade = CascadeType.ALL )
    private Set<Request> requests = new HashSet<>();
}