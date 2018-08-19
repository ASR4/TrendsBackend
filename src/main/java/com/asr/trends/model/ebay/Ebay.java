package com.asr.trends.model.ebay;

public class Ebay
{
    private GetMostWatchedItemsResponse getMostWatchedItemsResponse;

    public GetMostWatchedItemsResponse getGetMostWatchedItemsResponse ()
    {
        return getMostWatchedItemsResponse;
    }

    public void setGetMostWatchedItemsResponse (GetMostWatchedItemsResponse getMostWatchedItemsResponse)
    {
        this.getMostWatchedItemsResponse = getMostWatchedItemsResponse;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [getMostWatchedItemsResponse = "+getMostWatchedItemsResponse+"]";
    }
}
