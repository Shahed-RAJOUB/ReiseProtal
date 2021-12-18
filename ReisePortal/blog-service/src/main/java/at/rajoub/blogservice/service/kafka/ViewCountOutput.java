package at.rajoub.blogservice.service.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Configuration
public interface ViewCountOutput {

    @Output("blog-service.view-count")
    MessageChannel outputViewCount();

}
