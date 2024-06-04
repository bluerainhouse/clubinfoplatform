package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    @Column(name = "club_name", nullable = false)
    private String clubName;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "type", nullable = false)
    private String type;

    @Lob
    @Column(name = "data", columnDefinition = "TEXT")
    private String data;

    public Club(String clubName, String fullName, String type, String data) {
        this.clubName = clubName;
        this.fullName = fullName;
        this.type = type;
        this.data = data;
    }
}
