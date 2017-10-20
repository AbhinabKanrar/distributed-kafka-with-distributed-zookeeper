/**
 * 
 */
package com.mabsisa.kafkademo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * @author abhinab
 *
 */
@Configuration
@EnableKafka
public class ProducerConfig {

	public static final String BOOTSTRAP_SERVERS_CONFIG = "bootstrap.servers";
	public static final String KEY_SERIALIZER_CLASS_CONFIG = "key.serializer";
	public static final String VALUE_SERIALIZER_CLASS_CONFIG = "value.serializer";

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
		configProps.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
