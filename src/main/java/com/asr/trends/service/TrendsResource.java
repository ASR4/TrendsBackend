package com.asr.trends.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.asr.trends.model.TrendResponse;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;

/**
 * Defines endpoint functions APIs.
 */
@Api(name = "trending", version = "v2",
scopes = {Constants.EMAIL_SCOPE },
        clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
        description = "API for trends endpoints.")

public class TrendsResource {
	
	@Autowired
	private TrendsService trendsService = new TrendsService();

    @ApiMethod(name = "fetchTrend", path = "fetchTrend",
            httpMethod = HttpMethod.GET)

    public TrendResponse fetchTrend (@Named("trend") String clientName) {
    	 return trendsService.fetchListOfTrends(clientName);
    }
    
    @ApiMethod(name = "fetchAll", path = "fetchAll",
            httpMethod = HttpMethod.GET)

    public TrendResponse fetchTrendAll () {
    	 return trendsService.fetchAll();
    }
    
}
