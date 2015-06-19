package fr.boivina.meteoprobe.client.mq;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.boivina.meteoprobe.client.message.MeteoData;

public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String jsonString) {

		MeteoData data = null;
		try {
			data = new ObjectMapper().readValue(jsonString, MeteoData.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(data != null) {
			System.out.println("Temperature received <" + data.getTemperature() + "°C>");
			latch.countDown();
		}
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}