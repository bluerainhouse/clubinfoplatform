package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ano_id")
    private Long anoID;

    @Column(name = "club_id", nullable = false)
    private Long clubID;

    @Column(name = "user_id", nullable = false)
    private Long userID;

    @Column(nullable = false)
    private String content;

    @Column(name = "ins_date", nullable = false)
    private Date insDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "club_manager_id", nullable = false)
    private ClubManager clubManager;

    @OneToMany(mappedBy = "announcement", cascade = CascadeType.ALL)
    private Set<Stars> stars = new HashSet<>();

    public Announcement() {
    }

    public Announcement(Long clubID, Long userID, String content, Date insDate, ClubManager clubManager) {
        this.clubID = clubID;
        this.userID = userID;
        this.content = content;
        this.insDate = insDate;
        this.clubManager = clubManager;
    }

    public Long getAnoID() {
        return anoID;
    }

    public void setAnoID(Long anoID) {
        this.anoID = anoID;
    }

    public Long getClubID() {
        return clubID;
    }

    public void setClubID(Long clubID) {
        this.clubID = clubID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public ClubManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
    }

    public Set<Stars> getStars() {
        return stars;
    }

    public void setStars(Set<Stars> stars) {
        this.stars = stars;
    }
}
