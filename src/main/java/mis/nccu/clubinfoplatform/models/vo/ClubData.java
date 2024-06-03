package mis.nccu.clubinfoplatform.models.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ClubData {
    @JsonProperty("name")
    private String name;
    @JsonProperty("lessonTime")
    private String lessonTime;
    @JsonProperty("activityTime")
    private String activityTime;
    @JsonProperty("description")
    private String description;
    @JsonProperty("socialLink")
    private String socialLink;
    @JsonProperty("photos")
    private List<Photo> photos;
    @Data
    private static class Photo{
        @JsonProperty("url")
        private String url;
    }
}
