package com.asr.trends.model;

import java.util.List;

public class Trends {
	private String logo;

	private List<Trend> trend;

	private String numOfTrends;

	private String type;

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Trend> getTrend() {
		return trend;
	}

	public void setTrend(List<Trend> trend) {
		this.trend = trend;
	}

	public String getNumOfTrends() {
		return numOfTrends;
	}

	public void setNumOfTrends(String numOfTrends) {
		this.numOfTrends = numOfTrends;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [logo = "+logo+", trend = "+trend+", numOfTrends = "+numOfTrends+", type = "+type+"]";
	}
}