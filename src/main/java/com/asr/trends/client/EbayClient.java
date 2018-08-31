package com.asr.trends.client;


import com.asr.trends.model.Trend;
import com.asr.trends.model.Trends;
import com.asr.trends.model.ebay.Ebay;
import com.asr.trends.model.ebay.Item;

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

public class EbayClient {
    private static String COMSUMER_ID;

    //constructor
    public EbayClient(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
            COMSUMER_ID = properties.getProperty("ebay_customer_id");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Trends getMostViewedItems() {

        String url = "http://svcs.ebay.com/MerchandisingService?OPERATION-NAME=getMostWatchedItems&SERVICE-NAME=MerchandisingService&SERVICE-VERSION=1.1.0&CONSUMER-ID=" + COMSUMER_ID + "&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&maxResults=10";
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
//				System.out.println(line);
                result.append(line);
            }

            //Converting json to Stocktwits pojo and then to Trends pojo
            System.out.println(jsonToPojo(result.toString()));
            Ebay ebay = jsonToPojo(result.toString());
            List<Item> items = ebay.getGetMostWatchedItemsResponse().getItemRecommendations().getItem();

            List<Trend> listOfTrend = new ArrayList<Trend>();
            for(Item item  : items) {
                Trend trend = new Trend();
                trend.setTitle(item.getTitle());
                trend.setLink( item.getViewItemURL()); // There is no UFT8 encoding of url in response
                trend.setImage(item.getImageURL());
                listOfTrend.add(trend);
            }
            trends.setLogo("Ebay_logo");
            trends.setNumOfTrends("10");
            trends.setTrend(listOfTrend.subList(0, 9));
            trends.setType("Ebay");

            return trends;
        }
        catch(Exception e){
            //TODO
        }

        return trends;
    }

    private Ebay jsonToPojo(String json) {
        ObjectMapper mapper = new ObjectMapper();

        Ebay ebay = null;
        try {
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ebay = mapper.readValue(json, Ebay.class); // parent class
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
        System.out.println(ebay);

        return ebay;
    }

    public static void main(String args[]) {
        EbayClient ebay = new EbayClient();
        ebay.getMostViewedItems();
    }
}


