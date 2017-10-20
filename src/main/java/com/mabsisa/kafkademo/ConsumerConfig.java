/**
 * 
 */
package com.mabsisa.kafkademo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

/**
 * @author abhinab
 *
 */
@Configuration
@EnableKafka
public class ConsumerConfig {

	public static final String BOOTSTRAP_SERVERS_CONFIG = "bootstrap.servers";
	public static final String GROUP_ID_CONFIG = "group.id";
	public static final String KEY_DESERIALIZER_CLASS_CONFIG = "key.deserializer";
	public static final String VALUE_DESERIALIZER_CLASS_CONFIG = "value.deserializer";

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
		props.put(GROUP_ID_CONFIG, "mabsisa");
		props.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConcurrency(3);
		factory.getContainerProperties().setPollTimeout(30000);
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public Listener listener() {
		return new Listener();
	}
	
}
