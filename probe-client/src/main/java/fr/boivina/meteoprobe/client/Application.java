package fr.boivina.meteoprobe.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.boivina.meteoprobe.client.configuration.MQConfiguration;
import fr.boivina.meteoprobe.client.message.MeteoData;

@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

    @Scheduled(fixedRate = 10000)
	private void sendMeteoData() throws JsonProcessingException {
		MeteoData data = new MeteoData();
		LOGGER.info("Sending message... {}", data);
        
        ObjectMapper mapper = new ObjectMapper();
        String dataJson = mapper.writeValueAsString(data);
        rabbitTemplate.convertAndSend(MQConfiguration.QUEUE_NAME, dataJson);
	}
}