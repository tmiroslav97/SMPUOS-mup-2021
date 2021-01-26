package rs.uns.acs.ftn.VehicleService.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "licences")
public class LicencePOJO {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "origin_date", nullable = false)
    private Calendar originDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiration_date", nullable = false)
    private Calendar expirationDate;

    @Column(name = "valid", nullable = false)
    private boolean valid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonPOJO holder;

    @OneToMany(mappedBy = "licence", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TicketPOJO> tickets;

    public LicencePOJO () {
        super();
    }

    public void setOriginDate (Calendar originDate) {
        this.originDate = originDate;
    }

    public Calendar getOriginDate () {
        return originDate;
    }

    public void setExpirationDate (Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Calendar getExpirationDate () {
        return expirationDate;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public PersonPOJO getHolder() {
        return holder;
    }

    public void setHolder (PersonPOJO holder) {
        this.holder = holder;
    }

    public void setID (Integer ID) {
        this.ID = ID;
    }

    public Integer getID () {
        return ID;
    }

    public void setTickets(List<TicketPOJO> tickets) {
        this.tickets = tickets;
    }

    public List<TicketPOJO> getTickets() {
        return tickets;
    }
}
