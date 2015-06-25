package fr.boivina.meteoprobe.client.message;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Coordinate used for meteo data sampling.
 * @author boivina
 *
 */
@JsonAutoDetect
public class Coordinate {

	private BigDecimal latitude;
	
	private BigDecimal longitude;

	public Coordinate() {
		
	}
	
	public Coordinate(BigDecimal latitude, BigDecimal longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
		
	}
}
