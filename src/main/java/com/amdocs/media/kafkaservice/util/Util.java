package com.amdocs.media.kafkaservice.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Util {
	private static final Logger logger = LoggerFactory.getLogger(Util.class);

	public static String convert(Object object) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = ow.writeValueAsString(object);

		} catch (Exception e) {
			logger.error("error in mapping profile");
		}
		return json;
	}

}
