package at.rajoub.blogservice.ValueObject;

import at.rajoub.blogservice.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    // Creating a rapper for the objects to use as a return type to return all the details about a blog


    private Blog blog;
    private Author author;
    private Location location;

}
