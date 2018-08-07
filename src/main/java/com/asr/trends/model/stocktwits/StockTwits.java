package com.asr.trends.model.stocktwits;

import java.util.List;

public class StockTwits
{
    private Response response;

    private List<Symbols> symbols;

    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        this.response = response;
    }

    public List<Symbols> getSymbols ()
    {
        return symbols;
    }

    public void setSymbols (List<Symbols> symbols)
    {
        this.symbols = symbols;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [response = "+response+", symbols = "+symbols+"]";
    }
}
