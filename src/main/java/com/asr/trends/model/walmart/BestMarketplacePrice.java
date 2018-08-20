package com.asr.trends.model.walmart;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BestMarketplacePrice
{
    private String offerType;

    private String price;

    private String availableOnline;

    private String sellerInfo;

    private String standardShipRate;

    private String clearance;

    private String twoThreeDayShippingRate;

    public String getOfferType ()
    {
        return offerType;
    }

    public void setOfferType (String offerType)
    {
        this.offerType = offerType;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getAvailableOnline ()
    {
        return availableOnline;
    }

    public void setAvailableOnline (String availableOnline)
    {
        this.availableOnline = availableOnline;
    }

    public String getSellerInfo ()
    {
        return sellerInfo;
    }

    public void setSellerInfo (String sellerInfo)
    {
        this.sellerInfo = sellerInfo;
    }

    public String getStandardShipRate ()
    {
        return standardShipRate;
    }

    public void setStandardShipRate (String standardShipRate)
    {
        this.standardShipRate = standardShipRate;
    }

    public String getClearance ()
    {
        return clearance;
    }

    public void setClearance (String clearance)
    {
        this.clearance = clearance;
    }

    public String getTwoThreeDayShippingRate ()
    {
        return twoThreeDayShippingRate;
    }

    public void setTwoThreeDayShippingRate (String twoThreeDayShippingRate)
    {
        this.twoThreeDayShippingRate = twoThreeDayShippingRate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [offerType = "+offerType+", price = "+price+", availableOnline = "+availableOnline+", sellerInfo = "+sellerInfo+", standardShipRate = "+standardShipRate+", clearance = "+clearance+", twoThreeDayShippingRate = "+twoThreeDayShippingRate+"]";
    }
}