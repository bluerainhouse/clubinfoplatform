package mis.nccu.clubinfoplatform.models.ids;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AttendsId implements Serializable {

    @Column(name = "activity_id")
    private Long activityId;

    @Column(name = "user_id")
    private Long userID;

    public AttendsId() {
    }

    public AttendsId(Long activityId, Long userID) {
        this.activityId = activityId;
        this.userID = userID;
    }

    // Getters, setters, equals, and hashCode methods

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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
        AttendsId that = (AttendsId) o;
        return Objects.equals(activityId, that.activityId) && Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, userID);
    }
}

