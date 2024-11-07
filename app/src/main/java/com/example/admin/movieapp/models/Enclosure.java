package com.example.admin.movieapp.models;

public class Enclosure
{
    private String link;

    private String length;

    private String type;

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getLength ()
    {
        return length;
    }

    public void setLength (String length)
    {
        this.length = length;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [link = "+link+", length = "+length+", type = "+type+"]";
    }
}

			