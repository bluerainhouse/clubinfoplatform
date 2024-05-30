package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.*;

@Entity
@Table(name = "joins")
public class Joins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "club_id")
    private Long clubId;

    public Joins() {
    }

    public Joins(Long id, Long userId, Long clubId) {
        this.id = id;
        this.userId = userId;
        this.clubId = clubId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }
}
