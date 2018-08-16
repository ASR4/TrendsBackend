package com.asr.trends.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.asr.trends.cache.ClientPicker;
import com.asr.trends.model.TrendResponse;
import com.asr.trends.model.Trends;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;

public class TrendsService {
	private final static Logger LOGGER = Logger.getLogger(TrendsService.class.getName());
	
	@Autowired
	private ClientPicker clientPicker;
	
	public String fetchListOfTrends(List<String> listOfTrendNames) {
		TrendResponse response = new TrendResponse();
		List<Trends> listOfTrends = new ArrayList<Trends>();
		for(String client : listOfTrendNames) {
			listOfTrends.add(clientPicker.fetchTrendsClient(client));
		}
		response.setTrends(listOfTrends);
		return marshalling(response);
	}
	
	private String marshalling(TrendResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";
		
		//Object to JSON in String
		try {
			jsonInString = mapper.writeValueAsString(response);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error converting trend object to json");
		}
		
		return jsonInString;
	}
}
