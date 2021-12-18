package at.rajoub.blogservice.service.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@Configuration
public interface ViewCountInput {

    @Input("blog-service.view-count")
    SubscribableChannel inputViewCount();

}
