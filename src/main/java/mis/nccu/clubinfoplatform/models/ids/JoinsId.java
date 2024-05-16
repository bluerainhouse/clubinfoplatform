package mis.nccu.clubinfoplatform.models.ids;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JoinsId implements Serializable {
    private Long userId;
    private Long clubId;

    public JoinsId() {
    }

    public JoinsId(Long userId, Long clubId) {
        this.userId = userId;
        this.clubId = clubId;
    }

    // getters, setters, equals and hashCode methods
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinsId joinsId = (JoinsId) o;
        return Objects.equals(userId, joinsId.userId) &&
                Objects.equals(clubId, joinsId.clubId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, clubId);
    }
}
