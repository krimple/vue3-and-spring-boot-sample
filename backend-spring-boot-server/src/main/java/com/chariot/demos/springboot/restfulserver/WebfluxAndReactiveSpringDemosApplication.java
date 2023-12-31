package com.chariot.demos.springboot.restfulserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@AutoConfiguration
public class WebfluxAndReactiveSpringDemosApplication {
	private static final Logger LOG = LoggerFactory.getLogger(WebfluxAndReactiveSpringDemosApplication.class);

	public static void main(String[] args) {
		WebfluxAndReactiveSpringDemosApplication.bootstrap(args);

	}

	public static ApplicationContext bootstrap(String[] args) {
		LOG.info("starting application");
		var ctx =  SpringApplication.run(WebfluxAndReactiveSpringDemosApplication.class, args);
		return ctx;
	}

}
