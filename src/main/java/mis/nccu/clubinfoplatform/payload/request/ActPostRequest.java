package mis.nccu.clubinfoplatform.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ActPostRequest {
    @NotBlank
    @JsonProperty("club_id")
    private Long clubId;

    @NotBlank
    @JsonProperty("start_date")
    private String startDate;

    @NotBlank
    @JsonProperty("start_time")
    private String startTime;

    @NotBlank
    @JsonProperty("end_date")
    private String endDate;

    @NotBlank
    @JsonProperty("end_time")
    private String endTime;

    @JsonProperty("title")
    private String title;

    @JsonProperty("detail")
    private String detail;

    @NotBlank
    @JsonProperty("type")
    private String type;

    @JsonProperty("fee")
    private String fee;
}