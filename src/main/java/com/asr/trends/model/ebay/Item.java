package com.asr.trends.model.ebay;

public class Item
{
    private String shippingType;

    private String primaryCategoryName;

    private ShippingCost shippingCost;

    private String globalId;

    private String itemId;

    private String viewItemURL;

    private String country;

    private String title;

    private String watchCount;

    private String subtitle;

    private String timeLeft;

    private String primaryCategoryId;

    private String imageURL;

    private BuyItNowPrice buyItNowPrice;

    public String getShippingType ()
    {
        return shippingType;
    }

    public void setShippingType (String shippingType)
    {
        this.shippingType = shippingType;
    }

    public String getPrimaryCategoryName ()
    {
        return primaryCategoryName;
    }

    public void setPrimaryCategoryName (String primaryCategoryName)
    {
        this.primaryCategoryName = primaryCategoryName;
    }

    public ShippingCost getShippingCost ()
    {
        return shippingCost;
    }

    public void setShippingCost (ShippingCost shippingCost)
    {
        this.shippingCost = shippingCost;
    }

    public String getGlobalId ()
    {
        return globalId;
    }

    public void setGlobalId (String globalId)
    {
        this.globalId = globalId;
    }

    public String getItemId ()
    {
        return itemId;
    }

    public void setItemId (String itemId)
    {
        this.itemId = itemId;
    }

    public String getViewItemURL ()
    {
        return viewItemURL;
    }

    public void setViewItemURL (String viewItemURL)
    {
        this.viewItemURL = viewItemURL;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getWatchCount ()
    {
        return watchCount;
    }

    public void setWatchCount (String watchCount)
    {
        this.watchCount = watchCount;
    }

    public String getSubtitle ()
    {
        return subtitle;
    }

    public void setSubtitle (String subtitle)
    {
        this.subtitle = subtitle;
    }

    public String getTimeLeft ()
    {
        return timeLeft;
    }

    public void setTimeLeft (String timeLeft)
    {
        this.timeLeft = timeLeft;
    }

    public String getPrimaryCategoryId ()
    {
        return primaryCategoryId;
    }

    public void setPrimaryCategoryId (String primaryCategoryId)
    {
        this.primaryCategoryId = primaryCategoryId;
    }

    public String getImageURL ()
    {
        return imageURL;
    }

    public void setImageURL (String imageURL)
    {
        this.imageURL = imageURL;
    }

    public BuyItNowPrice getBuyItNowPrice ()
    {
        return buyItNowPrice;
    }

    public void setBuyItNowPrice (BuyItNowPrice buyItNowPrice)
    {
        this.buyItNowPrice = buyItNowPrice;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [shippingType = "+shippingType+", primaryCategoryName = "+primaryCategoryName+", shippingCost = "+shippingCost+", globalId = "+globalId+", itemId = "+itemId+", viewItemURL = "+viewItemURL+", country = "+country+", title = "+title+", watchCount = "+watchCount+", subtitle = "+subtitle+", timeLeft = "+timeLeft+", primaryCategoryId = "+primaryCategoryId+", imageURL = "+imageURL+", buyItNowPrice = "+buyItNowPrice+"]";
    }
}