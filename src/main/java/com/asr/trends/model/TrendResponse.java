package com.asr.trends.model;

import java.util.List;

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
			
