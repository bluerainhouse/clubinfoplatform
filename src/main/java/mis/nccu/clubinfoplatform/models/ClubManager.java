package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "club_manager")
public class ClubManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_manager_id")
    private Long clubManagerID;

    @Column(name = "club_id", nullable = false)
    private Long clubID;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "clubManager", cascade = CascadeType.ALL)
    @JoinColumn(name = "club_manager_id", referencedColumnName = "club_manager_id", nullable = false)
    private Set<Manages> manages = new HashSet<>();

    @OneToMany(mappedBy = "clubManager", cascade = CascadeType.ALL)
    @JoinColumn(name = "club_id", referencedColumnName = "club_id", nullable = false)
    private Set<Announcement> announcements = new HashSet<>();

    @OneToMany(mappedBy = "clubManager", cascade = CascadeType.ALL)
    @JoinColumn(name = "club_id", referencedColumnName = "club_id", nullable = false)
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "clubManager", cascade = CascadeType.ALL)
    @JoinColumn(name = "club_manager_id", referencedColumnName = "club_manager_id", nullable = false)
    private Set<Identify> identifies = new HashSet<>();

    public ClubManager() {
    }

    public ClubManager(Long clubID, String role, String username, String password) {
        this.clubID = clubID;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public Long getClubManagerID() {
        return clubManagerID;
    }

    public void setClubManagerID(Long clubManagerID) {
        this.clubManagerID = clubManagerID;
    }

    public Long getClubID() {
        return clubID;
    }

    public void setClubID(Long clubID) {
        this.clubID = clubID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Manages> getManages() {
        return manages;
    }

    public void setManages(Set<Manages> manages) {
        this.manages = manages;
    }

    public Set<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Set<Announcement> announcements) {
        this.announcements = announcements;
    }

    public Set<Identify> getIdentifies() {
        return identifies;
    }

    public void setIdentifies(Set<Identify> identifies) {
        this.identifies = identifies;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
