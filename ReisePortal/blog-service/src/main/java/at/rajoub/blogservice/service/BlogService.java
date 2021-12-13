package at.rajoub.blogservice.service;

import at.rajoub.blogservice.client.AuthorServiceClient;
import at.rajoub.blogservice.client.LocationServiceClient;
import at.rajoub.blogservice.model.Author;
import at.rajoub.blogservice.model.Location;
import at.rajoub.blogservice.model.BlogEntry;
import at.rajoub.blogservice.entity.Blog;
import at.rajoub.blogservice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthorServiceClient authorServiceClient;
    private final LocationServiceClient locationServiceClient;

    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Optional<BlogEntry> getBlogWithId(long blogId) {
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
}
