package at.rajoub.authorservice.repository;

import at.rajoub.authorservice.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByAuthorEmailAndAuthorName(String email, String name);
}
