package com.asr.trends.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.asr.trends.cache.ClientPicker;
import com.asr.trends.model.TrendResponse;
import com.asr.trends.model.Trends;

public class TrendsService {
	private final static Logger LOGGER = Logger.getLogger(TrendsService.class.getName());
	private List<String> listOfClients = Arrays.asList("youtube", "ebay", "walmart", "google", "stocktwits", "twitter", "instagram");
	
	@Autowired
	private ClientPicker clientPicker = new ClientPicker();
	
	public TrendResponse fetchListOfTrends(String trendName) {
		TrendResponse response = new TrendResponse();
		List<Trends> listOfTrends = new ArrayList<Trends>();
		listOfTrends.add(clientPicker.fetchTrendsClient(trendName));
		response.setTrends(listOfTrends);
		return response;
	}
	
	public TrendResponse fetchAll() {
		TrendResponse response = new TrendResponse();
		List<Trends> listOfTrends = new ArrayList<Trends>();
		for(String trendName : listOfClients) {
			listOfTrends.add(clientPicker.fetchTrendsClient(trendName));
			response.setTrends(listOfTrends);
		}
		return response;
	}
	
}
