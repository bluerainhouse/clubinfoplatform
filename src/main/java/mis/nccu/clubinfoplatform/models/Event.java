package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @Column(name = "club_id", nullable = false)
    private Long clubID;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_manager_id", nullable = false)
    private ClubManager clubManager;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Attends> attends = new HashSet<>();

    public Event() {
    }

    public Event(Long clubID, Date startDate, Date endDate, String title, String type, ClubManager clubManager) {
        this.clubID = clubID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.type = type;
        this.clubManager = clubManager;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getClubID() {
        return clubID;
    }

    public void setClubID(Long clubID) {
        this.clubID = clubID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ClubManager getClubManager() {
        return clubManager;
    }

    public void setClubManager(ClubManager clubManager) {
        this.clubManager = clubManager;
    }

    public Set<Attends> getAttends() {
        return attends;
    }

    public void setAttends(Set<Attends> attends) {
        this.attends = attends;
    }
}
