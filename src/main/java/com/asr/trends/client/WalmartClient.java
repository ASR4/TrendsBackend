package com.asr.trends.client;

import com.asr.trends.helper.UTF8ToRawUrl;
import com.asr.trends.model.Trend;
import com.asr.trends.model.Trends;
import com.asr.trends.model.walmart.Items;
import com.asr.trends.model.walmart.Walmart;
import com.google.appengine.repackaged.org.codehaus.jackson.JsonParseException;
import com.google.appengine.repackaged.org.codehaus.jackson.map.DeserializationConfig;
import com.google.appengine.repackaged.org.codehaus.jackson.map.JsonMappingException;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WalmartClient {

    private static String API_KEY_WALMART;

    //constructor
    public WalmartClient(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
            API_KEY_WALMART = properties.getProperty("wallmart_api_key");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Trends getTrendingItems() {

        String url = "http://api.walmartlabs.com/v1/trends?apiKey=" + API_KEY_WALMART;
        Trends trends = new Trends();

        try{
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);

            HttpResponse response = client.execute(request);

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
				System.out.println(line);
                result.append(line);
            }

            //Converting json to Walmart pojo and then to Trends pojo
            System.out.println(jsonToPojo(result.toString()));
            Walmart walmart = jsonToPojo(result.toString());
            List<Items> items = walmart.getItems();

            List<Trend> listOfTrend = new ArrayList<Trend>();
            for(Items item  : items) {
                Trend trend = new Trend();
                trend.setTitle(item.getName());
                UTF8ToRawUrl.setUrl(item.getProductUrl());
                trend.setLink( UTF8ToRawUrl.getResult());
                trend.setImage(item.getThumbnailImage());
                listOfTrend.add(trend);
            }


            //https://www.walmart.com/ip/Sandisk-128-GB-Ultra-Microsdxc-Memory-Card-with-Adapter/46700585?sourceid=api014811cc63ce3142b4961218af0c0c31e4&affp1=DxetGLZg9faaknZvevdd5-n_TulIRdv5HmHFjm8l078&affilsrc=api&veh=aff&wmlspartner=readonlyapi
            //https://www.walmart.com/ip/Google-Play-100-Gift-Code-Email-Delivery/52897898?sourceid=api0129e446558191478497842d4b182e8adf&affp1=DxetGLZg9faaknZvevdd5-n_TulIRdv5HmHFjm8l078&affilsrc=api&veh=aff&wmlspartner=readonlyapi
            // trends.setLogo("replace_logo_from_resource");


            trends.setNumOfTrends("10");
            trends.setTrend(listOfTrend.subList(0, 9));
            trends.setType("Walmart");

            return trends;
        }
        catch(Exception e){
            //TODO
        }

        return trends;
    }

    private Walmart jsonToPojo(String json) {
        ObjectMapper mapper = new ObjectMapper();

        Walmart walmart = null;
        try {
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            walmart = mapper.readValue(json, Walmart.class); // parent class
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(walmart);

        return walmart;
    }

    public static void main(String args[]) {
        WalmartClient walmart = new WalmartClient();
        walmart.getTrendingItems();
    }
}

