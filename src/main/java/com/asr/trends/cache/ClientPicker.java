package com.asr.trends.cache;

import org.springframework.beans.factory.annotation.Autowired;

import com.asr.trends.client.StockTwitsClient;
import com.asr.trends.client.TwitterClient;
import com.asr.trends.model.Trends;

public class ClientPicker {
	@Autowired
	private TwitterClient twitterClient;
	
	@Autowired
	private StockTwitsClient stockTwitsClient;
	
	public Trends fetchTrendsClient(String clientName) {
		switch(clientName) {
		   case "twitter" :
		      return twitterClient.getTrendsFromLocation("canada");
		   
		   case "stocktwits" :
		      return stockTwitsClient.getTrendingSymbols();
		      
		   case "google" :
			  // Statements
			  break; // optional
		
		   case "youtube" :
			  // Statements
			  break; // optional	      
		   
		   // You can have any number of case statements.
		   default : // Optional
		      // Statements
		}
		return null;
		
	}
}
