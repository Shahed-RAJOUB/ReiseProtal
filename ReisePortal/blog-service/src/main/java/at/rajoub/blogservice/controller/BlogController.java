package at.rajoub.blogservice.controller;

import at.rajoub.blogservice.model.BlogEntry;
import at.rajoub.blogservice.entity.Blog;
import at.rajoub.blogservice.service.BlogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    private static final String BLOG_SERVICE = "BlogService";

    @PostMapping("/")
    public Blog saveLocation(@RequestBody Blog blog) {
        return blogService.saveBlog(blog);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = BLOG_SERVICE)
    public Optional<BlogEntry> getBlogWithId(@PathVariable("id") long blogId) {
        return blogService.getBlogWithId(blogId);
    }

    @GetMapping("/")
    @CircuitBreaker(name = BLOG_SERVICE)
    public List<BlogEntry> getBlogs() {
        return blogService.getBlogs();
    }
}
