package mis.nccu.clubinfoplatform.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class FollowRequest {
	@NotBlank
	@JsonProperty("user_id")
	private Long userId;
	@NotBlank
	@JsonProperty("club_id")
	private Long clubId;

	public FollowRequest(Long userId, Long clubId) {
		this.userId = userId;
		this.clubId = clubId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getClubId() {
		return clubId;
	}

	public void setClubId(Long clubId) {
		this.clubId = clubId;
	}
}