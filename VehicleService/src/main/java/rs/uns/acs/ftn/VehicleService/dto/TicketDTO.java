package rs.uns.acs.ftn.VehicleService.dto;

import rs.uns.acs.ftn.VehicleService.model.TicketPOJO;
import rs.uns.acs.ftn.VehicleService.util.Utility;

public class TicketDTO {

    private Integer ID;

    private String date;

    private String offense;

    private Integer points;

    private Integer licence;

    public TicketDTO () {
        super();
    }

    public TicketDTO (TicketPOJO pojo) {
        this.ID = pojo.getID();
        this.date = Utility.calToStr(pojo.getDate());
        this.offense = pojo.getOffense();
        this.points = pojo.getPoints();
        this.licence = pojo.getLicence().getID();
    }

    public String getDate() {
        return date;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer getLicence() {
        return licence;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public void setLicence(Integer licence) {
        this.licence = licence;
    }

    public String getOffense() {
        return offense;
    }
}
