package com.asr.trends.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asr.trends.cache.ClientCacheLoader;
import com.asr.trends.cache.ClientResponseCache;
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
	public TwitterClient getTwitterClient() {
		return new TwitterClient();
	}
}
