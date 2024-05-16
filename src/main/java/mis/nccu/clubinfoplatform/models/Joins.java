package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import mis.nccu.clubinfoplatform.models.ids.JoinsId;

@Entity
@Table(name = "joins")
public class Joins {

    @EmbeddedId
    private JoinsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private Club club;

    public Joins() {
    }

    public Joins(JoinsId id, User user, Club club) {
        this.id = id;
        this.user = user;
        this.club = club;
    }

    // getters and setters
}
