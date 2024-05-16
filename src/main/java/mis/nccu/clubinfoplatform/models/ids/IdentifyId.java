package mis.nccu.clubinfoplatform.models.ids;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class IdentifyId implements Serializable {

    @Column(name = "club_manager_id")
    private Long clubManagerID;

    @Column(name = "user_id")
    private Long userID;

    public IdentifyId() {
    }

    public IdentifyId(Long clubManagerID, Long userID) {
        this.clubManagerID = clubManagerID;
        this.userID = userID;
    }

    // Getters, setters, equals, and hashCode methods

    public Long getClubManagerID() {
        return clubManagerID;
    }

    public void setClubManagerID(Long clubManagerID) {
        this.clubManagerID = clubManagerID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifyId that = (IdentifyId) o;
        return Objects.equals(clubManagerID, that.clubManagerID) && Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubManagerID, userID);
    }
}
