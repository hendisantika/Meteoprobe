package fr.boivina.meteoprobe.client.message;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


/**
 * Message containing meteo data information.
 * @author boivina
 *
 */
@JsonAutoDetect
public class MeteoData implements Serializable{

	private static final int MAX_TEMPERATURE = 40;

	private static final int MIN_TEMPERATURE = 0;

	private static final double FRANCE_MIN_LATITUDE = 5.68;

	private static final double FRANCE_MIN_LONGITUDE = 41;

	private static final int FRANCE_WIDTH = 14;

	private static final int FRANCE_HEIGHT = 9;

	private static final long serialVersionUID = 1521969841267878264L;
	
	private BigDecimal temperature;
	
	private Coordinate coordinate;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate createDate;

	/**
	 * Constructor generating random data.
	 */
	public MeteoData() {
		
		// Set random coordinate and temperature.
		Random random = new Random();

		this.temperature = new BigDecimal((random.nextDouble()*MAX_TEMPERATURE)+MIN_TEMPERATURE);
		this.setCreateDate(LocalDate.now());
		this.coordinate = new Coordinate();
		
		this.coordinate.setLatitude(new BigDecimal((random.nextDouble()*FRANCE_HEIGHT)+FRANCE_MIN_LONGITUDE));
		this.coordinate.setLongitude(new BigDecimal((random.nextDouble()*FRANCE_WIDTH)-FRANCE_MIN_LATITUDE));
	}
	
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
		
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}
