package fr.boivina.meteoprobe.server.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.boivina.meteoprobe.server.message.MeteoData;

public interface MeteoDataDao extends MongoRepository<MeteoData, String> {

}
