package com.asr.trends.model.ebay;

import java.util.List;

public class ItemRecommendations
{
    private List<Item> item;

    public List<Item> getItem ()
    {
        return item;
    }

    public void setItem (List<Item> item)
    {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [item = "+item+"]";
    }
}
