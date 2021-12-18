package at.rajoub.blogservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ViewMessage implements KafkaMessage {

    private long timestamp;
    private Long blogId;

    @Builder
    public ViewMessage(Long blogId) {
        this.blogId = blogId;
        this.timestamp = Instant.now().toEpochMilli();
    }
}
