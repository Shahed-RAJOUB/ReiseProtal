package at.rajoub.blogservice.service.kafka;

import at.rajoub.blogservice.model.KafkaMessage;
import at.rajoub.blogservice.model.ViewMessage;
import at.rajoub.blogservice.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {

    private final ViewCountOutput viewCountOutput;
    private final BlogRepository blogRepository;

    @StreamListener("blog-service.view-count")
    @Transactional
    @NewSpan
    public void inputViewCount(@SpanTag(key = "message") ViewMessage viewMessage) {
        log.info("{}", viewMessage);
        blogRepository.incrementBlogViewCount(viewMessage.getBlogId());
    }

    @NewSpan
    public void sendMessage(@SpanTag(key = "message") KafkaMessage message) {
        viewCountOutput.outputViewCount()
                .send(MessageBuilder.withPayload(message).build());
    }
}
