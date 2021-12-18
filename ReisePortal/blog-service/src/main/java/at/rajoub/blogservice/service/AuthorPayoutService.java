package at.rajoub.blogservice.service;

import at.rajoub.blogservice.client.AuthorServiceClient;
import at.rajoub.blogservice.model.Author;
import at.rajoub.blogservice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorPayoutService {

    private final AuthorServiceClient authorServiceClient;
    private final BlogRepository blogRepository;

    @Value("${app.provision.centPerView}")
    private int centPerView;

    @Scheduled(cron = "0 * * * * *")
    public void payoutAuthors() {
        log.info("----------- Authors are being paid out! ------------------");
        Map<Integer, Author> authors = authorServiceClient.getAllAuthors().stream()
                .collect(Collectors.toMap(Author::getAuthorId, identity()));
        blogRepository.getAuthorsViews()
                .forEach(authorViews -> log.info("Author {} has received {}€ in provision revenue",
                        authors.get(authorViews.getAuthorId()).getAuthorName(),
                        (float) (centPerView * authorViews.getCount()) / 100));
    }
}
