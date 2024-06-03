package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Stars")
public class Stars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "ano_id")
    private Long anoId;

    public Stars(Long userId, Long anoId){
        this.userId = userId;
        this.anoId = anoId;
    }
}
