package com.asr.trends.model.walmart;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attributes
{
    private String color;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String compositeWood;

    //@JsonIgnoreProperties("finerCateg")

    public String getFinerCateg() {
        return finerCateg;
    }

    public void setFinerCateg(String finerCateg) {
        this.finerCateg = finerCateg;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String finerCateg;


    private String size;

    public String getColor ()
    {
        return color;
    }

    public void setColor (String color)
    {
        this.color = color;
    }

    public String getCompositeWood ()
    {
        return compositeWood;
    }

    public void setCompositeWood (String compositeWood)
    {
        this.compositeWood = compositeWood;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [color = "+color+", compositeWood = "+compositeWood+", size = "+size+"]";
    }
}
