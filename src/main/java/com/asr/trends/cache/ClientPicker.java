package com.asr.trends.cache;

import org.springframework.beans.factory.annotation.Autowired;

import com.asr.trends.client.EbayClient;
import com.asr.trends.client.StockTwitsClient;
import com.asr.trends.client.TwitterClient;
import com.asr.trends.client.WalmartClient;
import com.asr.trends.client.YoutubeClient;
import com.asr.trends.model.Trends;

public class ClientPicker {
	@Autowired
	private TwitterClient twitterClient = new TwitterClient();
	
	@Autowired
	private StockTwitsClient stockTwitsClient = new StockTwitsClient();
	
	private WalmartClient walmartClient = new WalmartClient();
	
	private EbayClient ebayClient = new EbayClient();
	
	private YoutubeClient youtubeClient = new YoutubeClient();
	
	public Trends fetchTrendsClient(String clientName) {
		switch(clientName) {
		   case "twitter" :
			  System.out.println("Inside clientpicker for TWITTER"); 
		      return twitterClient.getTrendsFromLocation("canada");
		   
		   case "stocktwits" :
			  System.out.println("Inside clientpicker for STOCKTWITS");
		      return stockTwitsClient.getTrendingSymbols();
		      
		   case "google" :
			  // Statements
			  break; // optional
		
		   case "youtube" :
//			  return youtubeClient.getTopVideos("US", "10", "mostPopular");	      
		   
		   case "walmart" :
			  return walmartClient.getTrendingItems();
			
		   case "ebay" :
			  return ebayClient.getMostViewedItems();
			  
		   case "instagram" :
			  break;	  
				  
		   // You can have any number of case statements.
		   default : // Optional
		      // Statements
		}
		return null;
		
	}
	
	/*
	 * {
	"trends" : [{
		"type" : "Twitter",
		"logo" : "www.twitter.logo.com",
		"numOfTrends" : 10,
		"trend" : [{
			"title" : "Ebay twitter",
			"link" : "http://www.ebay.com",
			"image" : "if.any.com"
		},
		{
			"title" : "Elon Musk twitter",
			"link" : "http://www.ebamusky.com",
			"image" : "if.any.com"
		}]		
	},
	{
		"type" : "StockTwits",
		"logo" : "www.stocktwits.logo.com",
		"numOfTrends" : 10,
		"trend" : [{
			"title" : "Ebay twitter",
			"link" : "http://www.ebay.com",
			"image" : "if.any.com"
		},
		{
			"title" : "Elon Musk twitter",
			"link" : "http://www.ebamusky.com",
			"image" : "if.any.com"
		}]		
	}]
}
	 * 
	 * */
}
