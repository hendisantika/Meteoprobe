package fr.boivina.meteoprobe.server.mq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.boivina.meteoprobe.server.dao.MeteoDataDao;
import fr.boivina.meteoprobe.server.message.MeteoData;

/**
 * Meteo data message processor
 * @author boivina
 *
 */
public class MeteoReceiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(MeteoReceiver.class);
	
	@Autowired
	private MeteoDataDao meteoDataDao;

	private CountDownLatch latch = new CountDownLatch(1);

	/**
	 * Receive the json message and persist it in the database.
	 * @param jsonString
	 * @throws IOException
	 */
	public void receiveMessage(String jsonString) throws IOException{

		MeteoData data = new ObjectMapper().readValue(jsonString, MeteoData.class);

		if(data != null) {
			LOGGER.info("Data received : {}", data);
			meteoDataDao.save(data);
		}
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}