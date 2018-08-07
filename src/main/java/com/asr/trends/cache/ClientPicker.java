package com.asr.trends.cache;

import javax.inject.Inject;

import com.asr.trends.client.StockTwitsClient;
import com.asr.trends.client.TwitterClient;
import com.asr.trends.model.Trends;

public class ClientPicker {
	@Inject
	private TwitterClient twitterClient;
	
	@Inject
	private StockTwitsClient stockTwitsClient;
	
	public Trends fetchTrendsClient(String clientName) {
		switch(clientName) {
		   case "youtube" :
		      return twitterClient.getTrendsFromLocation("canada");
		   
		   case "stocktwits" :
		      return stockTwitsClient.getTrendingSymbols();
		      
		   case "google" :
			  // Statements
			  break; // optional
		
		   case "twitter" :
			  // Statements
			  break; // optional	      
		   
		   // You can have any number of case statements.
		   default : // Optional
		      // Statements
		}
		return null;
		
	} 
}
