package at.rajoub.authorservice.controller;

import at.rajoub.authorservice.entity.Author;
import at.rajoub.authorservice.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@Slf4j
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/")
    public Author saveAuthor(@RequestBody Author author){
        log.info("Inside saveauthor of authorController");
        return authorService.saveAuthor(author);
    }
    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable("id") int authorId){
        return authorService.findAuthorById(authorId);
    }
    @GetMapping("/")
    public List<Author> selectAllAuthors(){
        return authorService.selectAllAuthors();
    }
}
