package com.asr.trends.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asr.trends.cache.ClientCacheLoader;
import com.asr.trends.cache.ClientPicker;
import com.asr.trends.cache.ClientResponseCache;
import com.asr.trends.client.StockTwitsClient;
import com.asr.trends.client.TwitterClient;

@Configuration
public class TrendsServiceFactory {

	@Bean
	public ClientCacheLoader getClientCacheLoader() {
		return new ClientCacheLoader();
	}
	
	@Bean
	public ClientResponseCache getClientResponseCache() {
		return new ClientResponseCache();
	}
	
	@Bean
	public ClientPicker getClientPicker() {
		return new ClientPicker();
	}
	
	@Bean
	public TwitterClient getTwitterClient() {
		return new TwitterClient();
	}
	
	@Bean
	public StockTwitsClient getStockTwitsClient() {
		return new StockTwitsClient();
	}
}
