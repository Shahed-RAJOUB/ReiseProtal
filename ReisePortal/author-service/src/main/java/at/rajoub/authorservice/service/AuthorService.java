package at.rajoub.authorservice.service;

import at.rajoub.authorservice.entity.Author;
import at.rajoub.authorservice.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {
        log.info("saving author {}", author);
        return authorRepository.findByAuthorEmailAndAuthorName(author.getAuthorEmail(), author.getAuthorName())
                .orElseGet(() -> authorRepository.save(author));
    }

    public Author findAuthorById(int authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    public List<Author> selectAllAuthors() {
        return authorRepository.findAll();
    }
}
