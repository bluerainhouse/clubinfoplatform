package mis.nccu.clubinfoplatform.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
	@NotBlank
	@JsonProperty("fullName")
	private String fullName;
	@NotBlank
	@JsonProperty("clubId")
	private Long clubId;
	@NotBlank
	@JsonProperty("selfIntro")
	private String selfIntro;
}