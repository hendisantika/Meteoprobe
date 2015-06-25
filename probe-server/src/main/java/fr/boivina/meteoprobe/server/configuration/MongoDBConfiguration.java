package fr.boivina.meteoprobe.server.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import com.mongodb.MongoClient;

import fr.boivina.meteoprobe.server.dao.MongoDBConverters.InstantToLongConverter;
import fr.boivina.meteoprobe.server.dao.MongoDBConverters.LocalDateToStringConverter;
import fr.boivina.meteoprobe.server.dao.MongoDBConverters.LongToInstantConverter;
import fr.boivina.meteoprobe.server.dao.MongoDBConverters.StringToLocalDateConverter;

@Configuration
public class MongoDBConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "test";
	}

	@Override
	public MongoClient mongo() throws Exception {
		return new MongoClient("localhost");
	}

	@Override
	public CustomConversions customConversions() {
		return new CustomConversions(Arrays.asList(
				new InstantToLongConverter(), new LongToInstantConverter(),
				new LocalDateToStringConverter(), new StringToLocalDateConverter()));
	}

}