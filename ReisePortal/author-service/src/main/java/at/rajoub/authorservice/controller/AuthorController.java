package at.rajoub.authorservice.controller;

import at.rajoub.authorservice.entity.Author;
import at.rajoub.authorservice.service.AuthorService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Slf4j
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    private static final String AUTHOR_SERVICE = "AuthorService";
    //private static final String FALLBACK_METHOD = "authorServiceFallBack";

    @PostMapping("/")
    public Author saveAuthor(@RequestBody Author author) {
        log.info("Inside saveauthor of authorController");
        return authorService.saveAuthor(author);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = AUTHOR_SERVICE)
    public Author findAuthorById(@PathVariable("id") int authorId) {
        return authorService.findAuthorById(authorId);
    }

//    private ResponseEntity<String> authorServiceFallBack(Exception e){
//        return new ResponseEntity<>("Author Service is taking longer than expected. Please try again later! "+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @GetMapping("/")
    public List<Author> selectAllAuthors() {
        return authorService.selectAllAuthors();
    }
}
