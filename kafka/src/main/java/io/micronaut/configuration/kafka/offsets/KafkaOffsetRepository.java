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

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

/**
 * A {@link CrudRepository} for {@link KafkaOffset} to be used with the {@link io.micronaut.configuration.kafka.annotation.OffsetStrategy OffsetStrategy} {@link io.micronaut.configuration.kafka.annotation.OffsetStrategy#LOCAL_REPOSITORY LOCAL_REPOSITORY}.
 *
 * @author Andreas Brenk
 * @since 5.7
 */
@Repository
public interface KafkaOffsetRepository extends CrudRepository<KafkaOffset, TopicPartition> {

    default KafkaOffset save(TopicPartition topicPartition, OffsetAndMetadata offsetAndMetadata) {
        return save(new KafkaOffset(topicPartition, offsetAndMetadata));
    }

}
