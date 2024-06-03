package mis.nccu.clubinfoplatform.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long id;

    @Column(name = "club_id", nullable = false)
    private Long clubId;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name= "title")
    private String title;

    @Column(name= "detail")
    private String detail;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "fee")
    private String fee;
}
