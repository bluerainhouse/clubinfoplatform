package mis.nccu.clubinfoplatform.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StarRequest {
	@NotBlank
	@JsonProperty("user_id")
	private Long userId;
	@NotBlank
	@JsonProperty("ano_id")
	private Long anoId;

	public StarRequest(Long userId, Long anoId) {
		this.userId = userId;
		this.anoId = anoId;
	}
}