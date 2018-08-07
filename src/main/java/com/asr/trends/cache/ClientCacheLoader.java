package com.asr.trends.cache;

import javax.inject.Inject;

import com.asr.trends.model.Trends;
import com.google.common.cache.CacheLoader;

public class ClientCacheLoader extends CacheLoader<String, Trends> {
	
	@Inject
	private ClientPicker clientPicker;
	
	@Override
	public Trends load(String clientName) throws Exception {
		return clientPicker.fetchTrendsClient(clientName);
	}

}
