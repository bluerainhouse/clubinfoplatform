package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import mis.nccu.clubinfoplatform.models.ids.ManagesId;

@Entity
@Table(name = "manages")
public class Manages {

    @EmbeddedId
    private ManagesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clubID")
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clubManagerID")
    @JoinColumn(name = "club_manager_id", nullable = false)
    private ClubManager clubManager;

    public Manages() {
    }

    public Manages(ManagesId id, Club club, ClubManager clubManager) {
        this.id = id;
        this.club = club;
        this.clubManager = clubManager;
    }

    public ManagesId getId() {
        return id;
    }

    public void setId(ManagesId id) {
        this.id = id;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public ClubManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
    }
}
