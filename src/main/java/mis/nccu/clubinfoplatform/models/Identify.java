package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import mis.nccu.clubinfoplatform.models.ids.IdentifyId;

@Entity
@Table(name = "identify")
public class Identify {

    @EmbeddedId
    private IdentifyId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clubManagerID")
    @JoinColumn(name = "club_manager_id", referencedColumnName = "club_manager_id", insertable = false, updatable = false)
    private ClubManager clubManager;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userID")
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    public Identify() {
    }

    public Identify(IdentifyId id, ClubManager clubManager, User user) {
        this.id = id;
        this.clubManager = clubManager;
        this.user = user;
    }

    // Getters and setters

    public IdentifyId getId() {
        return id;
    }

    public void setId(IdentifyId id) {
        this.id = id;
    }

    public ClubManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
