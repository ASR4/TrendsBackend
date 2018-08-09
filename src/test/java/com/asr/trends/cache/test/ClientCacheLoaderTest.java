package com.asr.trends.cache.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asr.trends.cache.ClientCacheLoader;
import com.asr.trends.configs.TrendsServiceFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TrendsServiceFactory.class)
public class ClientCacheLoaderTest {

	@Autowired
	private ClientCacheLoader clientCacheLoader;
	
	@Test
	public void dependencyInjectionShouldWork() {
		assertNotNull(clientCacheLoader);
	}
	
}
