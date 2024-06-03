package mis.nccu.clubinfoplatform.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mis.nccu.clubinfoplatform.models.vo.ClubData;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubDetailResponse {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("data")
	private ClubData clubData;
}