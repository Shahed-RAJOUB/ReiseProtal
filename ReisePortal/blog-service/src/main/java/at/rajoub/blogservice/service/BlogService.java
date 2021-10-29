package at.rajoub.blogservice.service;

import at.rajoub.blogservice.AuthorServiceClient;
import at.rajoub.blogservice.LocationServiceClient;
import at.rajoub.blogservice.ValueObject.Author;
import at.rajoub.blogservice.ValueObject.Location;
import at.rajoub.blogservice.ValueObject.ResponseTemplateVO;
import at.rajoub.blogservice.entity.Blog;
import at.rajoub.blogservice.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AuthorServiceClient authorServiceClient;

    @Autowired
    private LocationServiceClient locationServiceClient;


    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public ResponseTemplateVO getBlogWithId(int blogId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Blog blog = blogRepository.findById(blogId).orElseThrow();

        Author author = authorServiceClient.findAuthorById(blog.getAuthorId());
        Location location = locationServiceClient.findLocationById(blog.getLocationId());

        vo.setBlog(blog);
        vo.setAuthor(author);
        vo.setLocation(location);

        return vo;
    }
}
