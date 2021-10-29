package at.rajoub.blogservice.controller;

import at.rajoub.blogservice.ValueObject.ResponseTemplateVO;
import at.rajoub.blogservice.entity.Blog;
import at.rajoub.blogservice.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/")
    public Blog saveLocation(@RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getBlogWithId(@PathVariable("id") int blogId){
        return blogService.getBlogWithId(blogId);
    }
}
