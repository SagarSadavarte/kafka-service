package com.amdocs.media.kafkaservice.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProfilePublisher {
	
	@Value("${kafka.topic.name}")
	String profileTopic;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void publishProfileToKafka(String message) {
		this.kafkaTemplate.send(profileTopic,message);
	}
	

}
