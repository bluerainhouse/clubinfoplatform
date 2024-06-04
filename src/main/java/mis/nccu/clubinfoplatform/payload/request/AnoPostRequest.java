package mis.nccu.clubinfoplatform.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AnoPostRequest {
    @NotBlank
    @JsonProperty("club_id")
    private Long clubId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @NotBlank
    @JsonProperty("date")
    private String date;
}