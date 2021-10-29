package at.rajoub.blogservice;

import at.rajoub.blogservice.ValueObject.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("AUTHOR-SERVICE")
@RequestMapping("/authors")
public interface AuthorServiceClient {
    @GetMapping("/{id}")
    Author findAuthorById(@PathVariable("id") int authorId);
}
