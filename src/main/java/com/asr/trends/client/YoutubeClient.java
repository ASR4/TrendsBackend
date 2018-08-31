package com.asr.trends.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.asr.trends.model.Trend;
import com.asr.trends.model.youtube.Items;
import com.asr.trends.model.youtube.YouTube;
import com.google.appengine.repackaged.org.codehaus.jackson.map.DeserializationConfig;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;

public class YoutubeClient {
//https://www.googleapis.com/youtube/v3/videos?part=contentDetails&chart=mostPopular&regionCode=IN&maxResults=25&key=API_KEY
	private static String API_KEY = "";
	
	public YoutubeClient() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("config.properties");
		Properties properties = new Properties();
		try {
			properties.load(input);
			API_KEY = properties.getProperty("youtube_key");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public com.asr.trends.model.Trends getTopVideos(String regionCode, String maxResults, String chart) {
		com.asr.trends.model.Trends trendsList = new com.asr.trends.model.Trends();
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
//				System.out.println(line);
				result.append(line);
			}
			
			YouTube youTube = jsonToPojo(result.toString());
			 List<Items> items = youTube.getItems();
			 
			 List<Trend> listOfTrend = new ArrayList<Trend>();
	            for(Items item  : items) {
	            	String youTubeUrl = "https://www.youtube.com/watch?v=" + item.getId();
	                Trend trend = new Trend();
	                trend.setTitle(getTitleQuietly(item.getId()));
	                trend.setLink(youTubeUrl);
	                trend.setImage(getImageUrlQuietly(youTubeUrl, item.getId()));
	                listOfTrend.add(trend);
	            }
	            trendsList.setLogo("replace_logo_from_resource");
				trendsList.setNumOfTrends("10");
				trendsList.setTrend(listOfTrend.subList(0, 9));
				trendsList.setType("YouTube");
				return trendsList;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed to get trends: " + e.getMessage());
			System.exit(-1);
		}
		return trendsList;
	}
	
	private YouTube jsonToPojo(String json) {
		ObjectMapper mapper = new ObjectMapper();
		
		YouTube youTube = null;
		
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			youTube = mapper.readValue(json, YouTube.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return youTube;
	}
	
	public static String getTitleQuietly(String itemId) {
		String url = "https://www.googleapis.com/youtube/v3/videos?part=id%2C+snippet&id=" + itemId + "&key=" + API_KEY;

		String title = "";
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
//				System.out.println(line);
				result.append(line);
			}
			JSONObject jsonObject = new JSONObject(result.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("items");

            JSONObject object = jsonArray.getJSONObject(0);
            JSONObject snippet = object.getJSONObject("snippet");

            title = snippet.getString("title");
            
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Title : " + title);
		return title;
	}
	
	 public static String getImageUrlQuietly(String youtubeUrl, String itemId) {
//	        try {
//	            if (youtubeUrl != null) {
//	                return String.format("http://img.youtube.com/vi/%s/0.jpg", itemId);
//	            }
//	        } catch (UnsupportedOperationException e) {
//	            e.printStackTrace();
//	        }
//	        return null;
		 
		 String url = "https://www.googleapis.com/youtube/v3/videos?part=id%2C+snippet&id=" + itemId + "&key=" + API_KEY;

			String image = "";
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
//					System.out.println(line);
					result.append(line);
				}
				JSONObject jsonObject = new JSONObject(result.toString());
	            JSONArray jsonArray = jsonObject.getJSONArray("items");

	            JSONObject object = jsonArray.getJSONObject(0);
	            JSONObject snippet = object.getJSONObject("snippet");
	            JSONObject thumbnails = snippet.getJSONObject("thumbnails");
	            JSONObject defaultImage = thumbnails.getJSONObject("default");

	            image = defaultImage.getString("url");
	            
			} catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Image : " + image);
			return image;
		}

	public static void main(String args[]) {
		YoutubeClient youtubeClient = new YoutubeClient();
		youtubeClient.getTopVideos("IN", "10", "mostPopular");
	}
}
