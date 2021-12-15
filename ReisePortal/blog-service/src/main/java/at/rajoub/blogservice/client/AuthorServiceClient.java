package at.rajoub.blogservice.client;

import at.rajoub.blogservice.model.Author;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("author-service")
@LoadBalancerClient(name = "author-service")
public interface AuthorServiceClient {

    @GetMapping("/api/authors/{id}")
    Author findAuthorById(@PathVariable("id") int authorId);

    @PostMapping("/api/authors/")
    Author saveAuthor(@RequestBody Author author);

    @GetMapping("/api/authors/")
    List<Author> getAllAuthors();
}
