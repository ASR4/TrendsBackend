package com.asr.trends.model.stocktwits;

public class StockTwits
{
    private Response response;

    private Symbols[] symbols;

    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        this.response = response;
    }

    public Symbols[] getSymbols ()
    {
        return symbols;
    }

    public void setSymbols (Symbols[] symbols)
    {
        this.symbols = symbols;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [response = "+response+", symbols = "+symbols+"]";
    }
}
