package com.asr.trends.cache;

import javax.inject.Inject;

import com.asr.trends.client.TwitterClient;
import com.asr.trends.model.Trends;

public class ClientPicker {
	String clientName;
	
	@Inject
	private TwitterClient twitterClient;
	
	public ClientPicker(String clientName) {
		this.clientName = clientName;
	}
	
	public Trends fetchTrendsClient(String clientName) {
		switch(clientName) {
		   case "youtube" :
			   //TODO call a method that converts client response to Trends object for twitter
//		      return twitterClient.getTrendsFromLocation(loc);
		      break; // optional
		   
		   case "stocktwits" :
		      // Statements
		      break; // optional
		      
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
