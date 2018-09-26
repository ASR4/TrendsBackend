package com.asr.trends.model.instaTag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstaTag
{

   private  List<Data> data;

//    private Meta meta;

    public List<Data> getData ()
    {
        return data;
    }

    public void setData (List<Data> data)
    {
        this.data = data;
    }

//    public Meta getMeta ()
//    {
//        return meta;
//    }
//
//    public void setMeta (Meta meta)
//    {
//        this.meta = meta;
//    }

    @Override
    public String toString()
    {
//        return "ClassPojo [data = "+data+", meta = "+meta+"]";
        return "ClassPojo [data = "+data+"]";
    }
}

