package com.asr.trends.client;

import com.asr.trends.model.Trend;
import com.asr.trends.model.Trends;
import com.asr.trends.model.instaTag.Data;
import com.asr.trends.model.instaTag.InstaTag;
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

// class for getting instagram tags with "popular" keyword
public class InstagramClient {
    private static String Access_Token_Insta;
    private static String tag = "popular";

    //constructor
    public InstagramClient(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
            Access_Token_Insta = properties.getProperty("Insta_Access_Token");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Trends getPopularTags() {

        String url = "http://api.instagram.com/v1/tags/search?q=" + tag + "&access_token=" + Access_Token_Insta;
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

            //Converting json to instaTag pojo and then to Trends pojo
            System.out.println((result.toString()));
            InstaTag instaTag = jsonToPojo(result.toString());
           List<Data> tags = instaTag.getData(); // list of tags


            List<Trend> ListOfTags = new ArrayList<Trend>();
            for(Data tag  : tags) {
                Trend trend = new Trend();
                trend.setTitle(tag.getName());
                ListOfTags.add(trend);
            }

            trends.setNumOfTrends("10");
            trends.setTrend(ListOfTags.subList(0, 9));
            trends.setType("Walmart");


        return trends;

    }
        catch(Exception e){
            //TODO
        }

        return trends;
    }


    private InstaTag jsonToPojo(String json) {
        ObjectMapper mapper = new ObjectMapper();

        InstaTag instaTag = null;
        try {
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            instaTag = mapper.readValue(json, InstaTag.class); // parent class
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
        System.out.println(instaTag);

        return instaTag;
    }

    public static void main(String args[]) {
        InstagramClient instaClient = new InstagramClient();
        instaClient.getPopularTags();
    }
}

