package mis.nccu.clubinfoplatform.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActAllResponse {
    private Long id;

    private String title;

    private String type;

    private String clubName;
}