package at.rajoub.blogservice.client;

import at.rajoub.blogservice.model.Author;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("author-service")
@LoadBalancerClient(name = "author-service")
public interface AuthorServiceClient {

    @GetMapping("/api/authors/{id}")
    Author findAuthorById(@PathVariable("id") int authorId);
}
