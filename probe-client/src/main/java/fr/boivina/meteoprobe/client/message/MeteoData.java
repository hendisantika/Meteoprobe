package fr.boivina.meteoprobe.client.message;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class MeteoData implements Serializable{

	private static final long serialVersionUID = 1521969841267878264L;
	
	private BigDecimal temperature;

	public MeteoData(BigDecimal temperature) {
		super();
		this.temperature = temperature;
	}
	
	public MeteoData() {
		
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

}
