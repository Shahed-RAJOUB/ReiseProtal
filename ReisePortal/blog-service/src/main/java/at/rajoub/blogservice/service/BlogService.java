package at.rajoub.blogservice.service;

import at.rajoub.blogservice.client.AuthorServiceClient;
import at.rajoub.blogservice.client.LocationServiceClient;
import at.rajoub.blogservice.entity.Blog;
import at.rajoub.blogservice.model.Author;
import at.rajoub.blogservice.model.BlogEntry;
import at.rajoub.blogservice.model.BlogStats;
import at.rajoub.blogservice.model.Location;
import at.rajoub.blogservice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthorServiceClient authorServiceClient;
    private final LocationServiceClient locationServiceClient;

    public void saveBlogEntry(BlogEntry blogEntry) {
        Author author = authorServiceClient.saveAuthor(blogEntry.getAuthor());
        Location location = locationServiceClient.saveLocation(blogEntry.getLocation());
        blogRepository.save(blogEntry.getBlog().toBuilder()
                .authorId(author.getAuthorId())
                .locationId(location.getLocationId())
                .blogDate(LocalDate.now())
                .build());
    }

    @NewSpan
    public Optional<BlogEntry> getBlogWithId(@SpanTag(key = "blogId") long blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        if (blog.isEmpty()) {
            return Optional.empty();
        }

        Author author = authorServiceClient.findAuthorById(blog.orElseThrow().getAuthorId());
        Location location = locationServiceClient.findLocationById(blog.orElseThrow().getLocationId());

        return Optional.of(BlogEntry.builder()
                .blog(blog.orElseThrow())
                .author(author)
                .location(location)
                .build());
    }

    public List<BlogEntry> getBlogs() {
        return blogRepository.findAll()
                .stream()
                .map(blog -> {
                    Author author = authorServiceClient.findAuthorById(blog.getAuthorId());
                    Location location = locationServiceClient.findLocationById(blog.getLocationId());
                    return BlogEntry.builder()
                            .blog(blog)
                            .author(author)
                            .location(location)
                            .build();
                })
                .collect(Collectors.toList());
    }

    public List<BlogStats> getBlogStats() {
        Optional<Blog> topBlogOptional = blogRepository.findTopByBlogViewsMax();
        if (topBlogOptional.isEmpty()) {
            return emptyList();
        }
        Blog topBlog = topBlogOptional.orElseThrow();
        return List.of(
                BlogStats.builder()
                        .type("popular_location")
                        .stat("name", locationServiceClient.findLocationById(topBlog.getLocationId()).getLocationName())
                        .stat("count", Long.valueOf(topBlog.getBlogNumberOfViews()).toString())
                        .build(),
                BlogStats.builder()
                        .type("popular_blog")
                        .stat("name", topBlog.getBlogTitle())
                        .stat("author", authorServiceClient.findAuthorById(topBlog.getAuthorId()).getAuthorName())
                        .stat("count", Long.valueOf(topBlog.getBlogNumberOfViews()).toString())
                        .build(),
                BlogStats.builder()
                        .type("authors_registered")
                        .stat("count", Integer.valueOf(authorServiceClient.getAllAuthors().size()).toString())
                        .build(),
                BlogStats.builder()
                        .type("blog_visits")
                        .stat("count", blogRepository.sumAllBlogViews().toString())
                        .build());
    }
}
