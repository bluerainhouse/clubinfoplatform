package mis.nccu.clubinfoplatform.models.ids;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FollowsId implements Serializable {
    private Long userId;
    private Long clubId;

    public FollowsId() {
    }

    public FollowsId(Long userId, Long clubId) {
        this.userId = userId;
        this.clubId = clubId;
    }
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
        FollowsId followsId = (FollowsId) o;
        return Objects.equals(userId, followsId.userId) &&
                Objects.equals(clubId, followsId.clubId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, clubId);
    }
    // getters, setters, equals and hashCode methods
}

