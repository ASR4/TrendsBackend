package com.asr.trends.model.ebay;

public class GetMostWatchedItemsResponse
{
    private String timestamp;

    private String ack;

    private ItemRecommendations itemRecommendations;

    private String version;

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getAck ()
    {
        return ack;
    }

    public void setAck (String ack)
    {
        this.ack = ack;
    }

    public ItemRecommendations getItemRecommendations ()
    {
        return itemRecommendations;
    }

    public void setItemRecommendations (ItemRecommendations itemRecommendations)
    {
        this.itemRecommendations = itemRecommendations;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timestamp = "+timestamp+", ack = "+ack+", itemRecommendations = "+itemRecommendations+", version = "+version+"]";
    }
}
