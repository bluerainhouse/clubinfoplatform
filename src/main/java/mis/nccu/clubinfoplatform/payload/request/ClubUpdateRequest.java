package mis.nccu.clubinfoplatform.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mis.nccu.clubinfoplatform.models.vo.ClubData;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubUpdateRequest {
	@NotBlank
	@JsonProperty("clubId")
	private Long clubId;
	@NotBlank
	@JsonProperty("data")
	private ClubData data;
}