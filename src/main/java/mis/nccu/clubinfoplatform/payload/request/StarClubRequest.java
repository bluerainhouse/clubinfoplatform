package mis.nccu.clubinfoplatform.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StarClubRequest {
	@NotBlank
	@JsonProperty("user_id")
	private Long userId;
	@NotBlank
	@JsonProperty("club_id")
	private Long clubId;

	public StarClubRequest(Long userId, Long anoId) {
		this.userId = userId;
		this.clubId = anoId;
	}
}