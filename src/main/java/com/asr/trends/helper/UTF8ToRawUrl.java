package com.asr.trends.helper;

import java.io.UnsupportedEncodingException;

public class UTF8ToRawUrl {

    private static String url;
    private static String result;


    public static void setUrl(String url) {
        UTF8ToRawUrl.url = url;
    }


    public static String getResult() {
        convert();
        return result;
    }

    public static void convert()
    {
        try {
            result = java.net.URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {

        return "the RAW URL is" + result;
    }


}