package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import mis.nccu.clubinfoplatform.models.ids.AttendsId;

@Entity
@Table(name = "attends")
public class Attends {

    @EmbeddedId
    private AttendsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("activityId")
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", insertable = false, updatable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userID")
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public Attends() {
    }

    public Attends(AttendsId id, Event event, User user) {
        this.id = id;
        this.event = event;
        this.user = user;
    }

    // Getters and setters

    public AttendsId getId() {
        return id;
    }

    public void setId(AttendsId id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
