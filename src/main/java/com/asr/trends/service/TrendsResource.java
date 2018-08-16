package com.asr.trends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;

/**
 * Defines endpoint functions APIs.
 */
@Api(name = "trendsendpoints", version = "v1",
scopes = {Constants.EMAIL_SCOPE },
        clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
        description = "API for trends endpoints.")

public class TrendsResource {
	
	@Autowired
	private TrendsService trendsService;

//    @ApiMethod(name = "sayHello", path = "sayHello",
//            httpMethod = HttpMethod.GET)

//    public String fetchTrend() {
//        return new HelloClass();
//    }

    @ApiMethod(name = "fetchListOfTrends", path = "fetchTrends",
            httpMethod = HttpMethod.GET)

    public String fetchListOfTrends (@Named("listOfTrends") List<String> clientNames) {
        return trendsService.fetchListOfTrends(clientNames);
    }
    
//    @ApiMethod(name = "sayHelloByNamePeriod", path = "sayHelloByNamePeriod",
//            httpMethod = HttpMethod.GET)

//    public String sayHelloByNamePeriod (@Named("name") String name, @Named("period") String period) {
//        return new HelloClass(name, period);
//    }
}
