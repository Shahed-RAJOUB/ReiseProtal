package at.rajoub.blogservice.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private int authorId;
    private String authorName;
    private String authorEmail;
}
