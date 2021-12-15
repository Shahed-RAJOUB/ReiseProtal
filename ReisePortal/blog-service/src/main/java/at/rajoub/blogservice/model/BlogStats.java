package at.rajoub.blogservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.Map;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogStats {

    private String type;
    @Singular
    private Map<String, String> stats;
}
