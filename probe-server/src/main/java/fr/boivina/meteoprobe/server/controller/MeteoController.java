package fr.boivina.meteoprobe.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.boivina.meteoprobe.server.dao.MeteoDataDao;
import fr.boivina.meteoprobe.server.message.MeteoData;

@RestController
public class MeteoController {

	@Autowired
	private MeteoDataDao meteoDataDao;
	
	@RequestMapping(value = "/datas", method = RequestMethod.GET)
	public Map<String,Object> datas() {
 
		Map<String,Object> map = new HashMap<>();
		List<MeteoData> list = meteoDataDao.findAll();
		for(MeteoData meteoData : list) {
			map.put(meteoData.getId(), meteoData);
		}
		
		return map;
	}
}