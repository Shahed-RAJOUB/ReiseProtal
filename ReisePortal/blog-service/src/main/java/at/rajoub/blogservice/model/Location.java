package at.rajoub.blogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Integer locationId;
    private String locationName;
    private String locationCity;
    private String locationStreet;
    private int locationZip;
}
