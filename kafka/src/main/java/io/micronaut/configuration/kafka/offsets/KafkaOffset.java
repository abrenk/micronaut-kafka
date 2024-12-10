/*
 * Copyright 2017-2024 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.configuration.kafka.offsets;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

/**
 * The data needed for storing a {@link org.apache.kafka.clients.consumer.ConsumerRecord#offset() Kafka offset}.
 *
 * @author Andreas Brenk
 * @since 5.7
 */
public record KafkaOffset(String topic, int partition, long offset, String metadata) {

    // TODO metadata is always null at the moment, set metadata to hostname or client-id?
    // see e.g. io/micronaut/configuration/kafka/processor/ConsumerStateSingle.java:82

    public KafkaOffset(TopicPartition topicPartition, OffsetAndMetadata offsetAndMetadata) {
        this(topicPartition.topic(), topicPartition.partition(), offsetAndMetadata.offset(), offsetAndMetadata.metadata());
    }
}
