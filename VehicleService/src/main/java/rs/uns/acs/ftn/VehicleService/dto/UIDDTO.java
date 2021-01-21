package rs.uns.acs.ftn.VehicleService.dto;

import javax.persistence.criteria.CriteriaBuilder;

public class UIDDTO {

    private String UID;

    public UIDDTO () {
        super();
    }

    public UIDDTO (String UID) {
        this.UID = UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUID() {
        return UID;
    }
}
