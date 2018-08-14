package com.asr.trends.cache;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import com.asr.trends.model.Trends;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class ClientResponseCache {
//http://www.codingpedia.org/ama/java-cache-example-with-guava
//https://dzone.com/articles/caching-guava
	
	@Autowired
	private ClientPicker clientPicker;
	
	private final LoadingCache<String, Trends> cache = CacheBuilder.newBuilder()
			.maximumSize(1000).build(new CacheLoader<String, Trends>() {
			@Override
			public Trends load(String clientName) throws Exception {
				return clientPicker.fetchTrendsClient(clientName);
			}
	});
	
	public Trends get(String key) throws ExecutionException{
		return cache.get(key);
	}
}
