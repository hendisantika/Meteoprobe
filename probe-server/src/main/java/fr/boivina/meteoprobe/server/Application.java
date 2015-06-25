package fr.boivina.meteoprobe.server;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import fr.boivina.meteoprobe.server.mq.MeteoReceiver;

@ComponentScan
@EnableAutoConfiguration
@EnableMongoRepositories
@EnableScheduling
public class Application extends SpringBootServletInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private MeteoReceiver receiver;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * Retreive meteo information every 10s and process it.
	 * @throws InterruptedException
	 */
	@Scheduled(fixedRate = 10000)
	private void reveiveMessages() throws InterruptedException {
		LOGGER.info("Checking for new message...");
		receiver.getLatch().await(100, TimeUnit.MILLISECONDS);
	}
}