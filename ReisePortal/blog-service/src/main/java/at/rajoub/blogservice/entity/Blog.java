package at.rajoub.blogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogId;
    private String blogTitle;
    private String blogText;
    private boolean blogIsViewed;
    private long blogNumberOfViews;
    private int authorId;
    private int locationId;
    private LocalDate blogDate;

}
