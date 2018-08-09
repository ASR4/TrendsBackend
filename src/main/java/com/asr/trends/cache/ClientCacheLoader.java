package com.asr.trends.cache;

import org.springframework.beans.factory.annotation.Autowired;

import com.asr.trends.model.Trends;
import com.google.common.cache.CacheLoader;

public class ClientCacheLoader extends CacheLoader<String, Trends> {
	
	@Autowired
	private ClientPicker clientPicker;
	
	@Override
	public Trends load(String clientName) throws Exception {
		return clientPicker.fetchTrendsClient(clientName);
	}

}
