package at.rajoub.authorservice.service;

import at.rajoub.authorservice.entity.Author;
import at.rajoub.authorservice.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {
        log.info("Inside saveauthor of authorService");
        return authorRepository.save(author);
    }

    public Author findAuthorById(int authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    public List<Author> selectAllAuthors() {
        return authorRepository.findAll();
    }
}
