package com.asr.trends.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TrendResponse {
    private List<Trends> trends;

    public List<Trends> getTrends ()
    {
        return trends;
    }

    public void setTrends (List<Trends> trends)
    {
        this.trends = trends;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [trends = "+trends+"]";
    }
}
			
