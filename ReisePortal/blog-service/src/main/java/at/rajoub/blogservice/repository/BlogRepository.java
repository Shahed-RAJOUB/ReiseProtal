package at.rajoub.blogservice.repository;

import at.rajoub.blogservice.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM blogs s ORDER BY blog_number_of_views desc LIMIT 1")
    Optional<Blog> findTopByBlogViewsMax();

    @Query(nativeQuery = true, value = "SELECT SUM(blog_number_of_views) FROM blogs")
    Long sumAllBlogViews();
}
