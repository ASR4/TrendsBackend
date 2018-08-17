package com.asr.trends.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.asr.trends.cache.ClientPicker;
import com.asr.trends.cache.ClientResponseCache;
import com.asr.trends.client.StockTwitsClient;
import com.asr.trends.client.TwitterClient;

@Configuration
@ComponentScan({"com.asr.trends"})
public class TrendsServiceFactory {
	
	@Bean
//	@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ClientResponseCache getClientResponseCache() {
		return new ClientResponseCache();
	}
	
	@Bean
//	@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
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
