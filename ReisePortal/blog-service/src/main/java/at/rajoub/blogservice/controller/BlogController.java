package at.rajoub.blogservice.controller;

import at.rajoub.blogservice.entity.Blog;
import at.rajoub.blogservice.model.BlogEntry;
import at.rajoub.blogservice.model.LocationStats;
import at.rajoub.blogservice.service.BlogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@CircuitBreaker(name = "BlogService")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/")
    public void saveBlogEntry(@RequestBody Blog blog) {
        blogService.saveBlogEntry(blog);
    }

    @GetMapping("/stats")
    public LocationStats getLocationStats() {
        return blogService.getLocationStats();
    }

    @GetMapping("/{id}")
    public Optional<BlogEntry> getBlogWithId(@PathVariable("id") long blogId) {
        return blogService.getBlogWithId(blogId);
    }

    @GetMapping("/")
    public List<BlogEntry> getBlogs() {
        return blogService.getBlogs();
    }
}
