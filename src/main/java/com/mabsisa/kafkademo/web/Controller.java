/**
 * 
 */
package com.mabsisa.kafkademo.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abhinab
 *
 */
@RestController
public class Controller {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("send")
	public @ResponseBody String send() {
		String uuid = UUID.randomUUID().toString();
		kafkaTemplate.send("mabgod", uuid);
		return uuid;
	}

}
