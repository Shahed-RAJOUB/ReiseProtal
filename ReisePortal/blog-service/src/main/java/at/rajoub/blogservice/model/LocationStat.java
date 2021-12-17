package at.rajoub.blogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class LocationStat {

    @JsonIgnore
    private Integer locationId;
    private String name;
    private long count;

    public LocationStat(Integer locationId, long count) {
        this.locationId = locationId;
        this.count = count;
    }
}
