package com.asr.trends.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GoogleClient {
//	https://trends.google.com/trends/hottrends/atom/hourly
	public void getTrendingTopics() {
		String url = "https://trends.google.com/trends/hottrends/atom/hourly";

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
		GoogleClient googleClient = new GoogleClient();
		googleClient.getTrendingTopics();
	}
}
