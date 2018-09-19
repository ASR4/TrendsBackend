package com.asr.trends.model.instaTag;

public class Data
{
    private String name;

    private String media_count;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getMedia_count ()
    {
        return media_count;
    }

    public void setMedia_count (String media_count)
    {
        this.media_count = media_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", media_count = "+media_count+"]";
    }
}
