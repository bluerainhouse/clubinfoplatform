package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "star_club")
public class StarClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "club_id")
    private Long clubId;

    public StarClub(Long userId, Long clubId){
        this.userId = userId;
        this.clubId = clubId;
    }
}
