package rs.uns.acs.ftn.VehicleService.dto;

public class RecordDTO {

    private String fName;

    private String lName;

    private String expirationDate;

    private Integer points;

    private String expired;

    public RecordDTO() {
        super();
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getExpired () {
        return expired;
    }

    public Integer getPoints () {
        return points;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }
}