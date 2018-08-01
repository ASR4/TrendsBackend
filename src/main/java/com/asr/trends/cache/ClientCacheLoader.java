package com.asr.trends.cache;

import com.asr.trends.model.Trends;
import com.google.common.cache.CacheLoader;

public class ClientCacheLoader extends CacheLoader<String, Trends> {

	@Override
	public Trends load(String clientName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
