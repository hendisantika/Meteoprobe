package fr.boivina.meteoprobe.server.dao;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;

public class MongoDBConverters {

	public static class InstantToLongConverter implements Converter<Instant, Long> {
		@Override
		public Long convert(Instant instant) {
			return instant.toEpochMilli();
		}
	}

	public static class LongToInstantConverter implements Converter<Long, Instant> {
		@Override
		public Instant convert(Long source) {
			return Instant.ofEpochMilli(source);
		}
	}

	public static class LocalDateToStringConverter implements Converter<LocalDate, String> {
		@Override
		public String convert(LocalDate localDate) {
			return localDate.toString();
		}
	}

	public static class StringToLocalDateConverter implements Converter<String, LocalDate> {
		@Override
		public LocalDate convert(String source) {
			return LocalDate.parse(source);
		}
	}
}