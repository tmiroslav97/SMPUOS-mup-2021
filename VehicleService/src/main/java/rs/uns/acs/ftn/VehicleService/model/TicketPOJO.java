package rs.uns.acs.ftn.VehicleService.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class TicketPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = true)
    private Calendar date;

    @Column(name = "offense", nullable = true)
    private String offense;

    @Column(name = "points", nullable = true)
    private Integer points;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private LicencePOJO licence;

    public TicketPOJO () {
        super();
    }

    public TicketPOJO(Integer ID, Calendar date, String offense, Integer points, LicencePOJO licence) {
        this.ID = ID;
        this.date = date;
        this.offense = offense;
        this.points = points;
        this.licence = licence;
    }

    public void setLicence (LicencePOJO licence) {
        this.licence = licence;
    }

    public LicencePOJO getLicence () {
        return licence;
    }

    public Calendar getDate() {
        return date;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getPoints() {
        return points;
    }

    public String getOffense() {
        return offense;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
