package com.asr.trends.model.stocktwits;

public class Symbols
{
    private String id;

    private String is_following;

    private String title;

    private String symbol;

    private String[] aliases;

    private String watchlist_count;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIs_following ()
    {
        return is_following;
    }

    public void setIs_following (String is_following)
    {
        this.is_following = is_following;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public String[] getAliases ()
    {
        return aliases;
    }

    public void setAliases (String[] aliases)
    {
        this.aliases = aliases;
    }

    public String getWatchlist_count ()
    {
        return watchlist_count;
    }

    public void setWatchlist_count (String watchlist_count)
    {
        this.watchlist_count = watchlist_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", is_following = "+is_following+", title = "+title+", symbol = "+symbol+", aliases = "+aliases+", watchlist_count = "+watchlist_count+"]";
    }
}