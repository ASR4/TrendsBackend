package com.asr.trends.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterClient {
	private static String CONSUMER_KEY = "";
	private static String CONSUMER_SECRET = "";
	private static String ACCESS_TOKEN = "";
	private static String ACCESS_TOKEN_SECRET = "";
	
	public TwitterClient() {
		Properties prop = new Properties();
	    InputStream input = null;
	    try {
	        input = new FileInputStream("config.properties");
	        // load a properties file
	        prop.load(input);
	        CONSUMER_KEY = prop.getProperty("twitter_consumer_key");
	        CONSUMER_SECRET = prop.getProperty("twitter_consumer_secret");
	        ACCESS_TOKEN = prop.getProperty("twitter_access_token");
	        ACCESS_TOKEN_SECRET = prop.getProperty("twitter_access_token_secret");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } 
	}
	
	public void getTrendsFromLocation(String loc){
		try {

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey(CONSUMER_KEY)
			.setOAuthConsumerSecret(CONSUMER_SECRET)
			.setOAuthAccessToken(ACCESS_TOKEN)
			.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();

			Integer idTrendLocation = getTrendLocationId(loc);

			if (idTrendLocation == null) {
				System.out.println("Trend Location Not Found");
				System.exit(0);
			}

			Trends trends = twitter.getPlaceTrends(idTrendLocation);
			for (int i = 0; i < trends.getTrends().length; i++) {
				System.out.println(trends.getTrends()[i].getName());
				System.out.println(trends.getTrends()[i].getURL());
			}

			System.exit(0);

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends: " + te.getMessage());
			System.exit(-1);
		}
	}

	private static Integer getTrendLocationId(String locationName) {

		int idTrendLocation = 0;

		try {

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			.setOAuthConsumerKey(CONSUMER_KEY)
			.setOAuthConsumerSecret(CONSUMER_SECRET)
			.setOAuthAccessToken(ACCESS_TOKEN)
			.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();

			ResponseList<Location> locations;
			locations = twitter.getAvailableTrends();

			for (Location location : locations) {
				if (location.getName().toLowerCase().equals(locationName.toLowerCase())) {
					idTrendLocation = location.getWoeid();
					break;
				}
			}

			if (idTrendLocation > 0) {
				return idTrendLocation;
			}

			return null;

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends: " + te.getMessage());
			return null;
		}

	}
	
	public static void main(String[] args) {
		TwitterClient tClient = new TwitterClient();
		tClient.getTrendsFromLocation("canada");
	}
	
}