package fr.boivina.meteoprobe.server.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.boivina.meteoprobe.server.dao.MeteoDataDao;

@Controller
public class MongoController {

	@Autowired
	private MeteoDataDao meteoDataDao;

	@RequestMapping(value = "/mongo/drop", method = RequestMethod.GET)
	public String findUsers(Map<String, Object> model) {
 
		meteoDataDao.deleteAll();
		
		return "index";
	}
	
}
