package mis.nccu.clubinfoplatform.models.ids;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ManagesId implements Serializable {

    @Column(name = "club_id")
    private Long clubID;

    @Column(name = "club_manager_id")
    private Long clubManagerID;

    public ManagesId() {
    }

    public ManagesId(Long clubID, Long clubManagerID) {
        this.clubID = clubID;
        this.clubManagerID = clubManagerID;
    }

    public Long getClubID() {
        return clubID;
    }

    public void setClubID(Long clubID) {
        this.clubID = clubID;
    }

    public Long getClubManagerID() {
        return clubManagerID;
    }

    public void setClubManagerID(Long clubManagerID) {
        this.clubManagerID = clubManagerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagesId managesId = (ManagesId) o;

        if (!clubID.equals(managesId.clubID)) return false;
        return clubManagerID.equals(managesId.clubManagerID);
    }

    @Override
    public int hashCode() {
        int result = clubID.hashCode();
        result = 31 * result + clubManagerID.hashCode();
        return result;
    }
}
