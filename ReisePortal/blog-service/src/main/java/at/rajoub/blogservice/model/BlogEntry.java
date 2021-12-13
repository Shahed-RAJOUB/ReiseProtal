package at.rajoub.blogservice.model;

import at.rajoub.blogservice.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BlogEntry {

    private Blog blog;
    private Author author;
    private Location location;

}
