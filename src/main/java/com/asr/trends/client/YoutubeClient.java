package com.asr.trends.client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class YoutubeClient {
//https://www.googleapis.com/youtube/v3/videos?part=contentDetails&chart=mostPopular&regionCode=IN&maxResults=25&key=API_KEY
	private static String API_KEY = "";
	
	public YoutubeClient() {
		Properties prop = new Properties();
	    InputStream input = null;
	    try {
	        input = new FileInputStream("config.properties");
	        // load a properties file
	        prop.load(input);
	        API_KEY = prop.getProperty("youtube_key");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } 
	}
	public void getTopVideos(String regionCode, String maxResults, String chart) {
		String url = "https://www.googleapis.com/youtube/v3/videos?part=contentDetails&"
				+ "chart=" + chart + "&regionCode=" + regionCode + "&maxResults=" + maxResults 
				+ "&key=" + API_KEY;

		try{
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);

			HttpResponse response = client.execute(request);

			System.out.println("Response Code : " 
	                	+ response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
				result.append(line);
			}
		}
		catch(Exception e){
			
		}
	}
	
	public static void main(String args[]) {
		YoutubeClient youtubeClient = new YoutubeClient();
		youtubeClient.getTopVideos("IN", "10", "mostPopular");
	}
}
