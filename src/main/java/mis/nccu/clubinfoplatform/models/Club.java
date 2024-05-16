package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long clubID;

    @Column(nullable = false)
    private String clubName;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Follows> follows = new HashSet<>();

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Joins> joins = new HashSet<>();

    public Club() {
    }

    public Club(Long clubID, String clubName, String type) {
        this.clubID = clubID;
        this.clubName = clubName;
        this.type = type;
    }

    public Long getClubID() {
        return clubID;
    }

    public void setClubID(Long clubID) {
        this.clubID = clubID;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Follows> getFollows() {
        return follows;
    }

    public void setFollows(Set<Follows> follows) {
        this.follows = follows;
    }

    public Set<Joins> getJoins() {
        return joins;
    }

    public void setJoins(Set<Joins> joins) {
        this.joins = joins;
    }
}
