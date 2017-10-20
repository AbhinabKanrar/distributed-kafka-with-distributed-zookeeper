package com.mabsisa.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class Listener {

	@KafkaListener(topics = "mabgod", group = "mabsisa")
	public void listen(ConsumerRecord<?, ?> record) {
		System.out.println("Received Messasge in group mabsisa: " + record);
	}

}
