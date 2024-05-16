package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import mis.nccu.clubinfoplatform.models.ids.StarsId;

@Entity
@Table(name = "stars")
public class Stars {

    @EmbeddedId
    private StarsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("anoID")
    @JoinColumn(name = "ano_id", referencedColumnName = "ano_id", insertable = false, updatable = false)
    private Announcement announcement;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userID")
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public Stars() {
    }

    public Stars(StarsId id, Announcement announcement, User user) {
        this.id = id;
        this.announcement = announcement;
        this.user = user;
    }

    // Getters and setters

    public StarsId getId() {
        return id;
    }

    public void setId(StarsId id) {
        this.id = id;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
