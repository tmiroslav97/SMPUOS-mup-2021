package rs.uns.acs.ftn.VehicleService.dto;

import rs.uns.acs.ftn.VehicleService.model.LicencePOJO;
import rs.uns.acs.ftn.VehicleService.util.Utility;

public class LicenceDTO {

    private String creationDate;

    private String expirationDate;

    private String valid;

    private Integer ID;

    private String holder;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getID() {
        return ID;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getHolder() {
        return holder;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getValid() {
        return valid;
    }

    public LicenceDTO (LicencePOJO pojo) {
        this.creationDate = Utility.calToStr(pojo.getOriginDate());
        this.ID = pojo.getID();
        this.expirationDate = Utility.calToStr(pojo.getExpirationDate());
        this.holder = pojo.getHolder().getUID();
        if (pojo.isValid()) {
            this.valid = "true";
        } else {
            this.valid = "false";
        }
    }

    public LicenceDTO () {
        super();
    }

}
