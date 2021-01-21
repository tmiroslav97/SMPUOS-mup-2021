package rs.uns.acs.ftn.CentralRegistryService.model;

import lombok.*;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbColumnConstants;
import rs.uns.acs.ftn.CentralRegistryService.common.db.DbTableConstants;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = DbTableConstants.ADDRESS)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = DbColumnConstants.STREET, nullable = false)
    private String street;

    @Column(name = DbColumnConstants.NUMBER, nullable = false)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @OneToMany(mappedBy = "address",
            cascade = CascadeType.ALL)
    private Set<CitizenAddress> citizens = new HashSet<>();
}
