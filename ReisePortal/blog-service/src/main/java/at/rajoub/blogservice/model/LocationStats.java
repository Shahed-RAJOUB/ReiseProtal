package at.rajoub.blogservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class LocationStats {

    private List<LocationStat> monthly;
    private List<LocationStat> allTime;
}
