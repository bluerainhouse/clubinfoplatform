package mis.nccu.clubinfoplatform.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActOneResponse {
    private String clubName;

    private String startDate;

    private String startTime;

    private String endDate;

    private String endTime;

    private String title;

    private String detail;

    private String type;

    private String fee;
}