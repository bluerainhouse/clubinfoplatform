package mis.nccu.clubinfoplatform.models.ids;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

@Embeddable
public class StarsId implements Serializable {

    @Column(name = "ano_id")
    private Long anoID;

    @Column(name = "user_id")
    private Long userID;

    public StarsId() {
    }

    public StarsId(Long anoID, Long userID) {
        this.anoID = anoID;
        this.userID = userID;
    }

    // Getters, setters, equals, and hashCode methods

    public Long getAnoID() {
        return anoID;
    }

    public void setAnoID(Long anoID) {
        this.anoID = anoID;
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
        StarsId starsId = (StarsId) o;
        return Objects.equals(anoID, starsId.anoID) && Objects.equals(userID, starsId.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anoID, userID);
    }
}
