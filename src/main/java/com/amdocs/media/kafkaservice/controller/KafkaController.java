package com.amdocs.media.kafkaservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amdocs.media.kafkaservice.dto.Profile;
import com.amdocs.media.kafkaservice.publisher.KafkaProfilePublisher;
import com.amdocs.media.kafkaservice.util.Util;

@Controller
@RequestMapping("/kafka/profile")
public class KafkaController {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
	
	@Autowired
	KafkaProfilePublisher kafkaProfilePublisher;
	
	@GetMapping("/ping")
	public void ping() {
		logger.info("kafka-service/ping called");
		System.out.println("kafka-service/ping called");
	}
	
	@PutMapping("/put")
	public ResponseEntity<Profile> putProfile(@RequestBody Profile profile) {
		logger.info("put service called for profile: ", profile);
		kafkaProfilePublisher.publishProfileToKafka(Util.convert(profile));
		logger.info("put service completed: ");
		return new ResponseEntity<>(profile,HttpStatus.OK);
	}

}
