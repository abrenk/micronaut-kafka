package docs.producer.fallback;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Requires;

@Requires(property = "spec.name", value = "MessageClientFallbackSpec")
@KafkaClient
public interface MessageClient {

    @Topic("messages")
    void send(String message);
}