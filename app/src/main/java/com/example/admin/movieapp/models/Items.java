package com.example.admin.movieapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Items implements Parcelable
{
    private String content;

    private String guid;

    private String author;

    private String pubDate;

    private String title;

    private String thumbnail;

    private Enclosure enclosure;

    private String description;

    private String link;

    private String[] categories;

    protected Items(Parcel in) {
        content = in.readString();
        guid = in.readString();
        author = in.readString();
        pubDate = in.readString();
        title = in.readString();
        thumbnail = in.readString();
        description = in.readString();
        link = in.readString();
        categories = in.createStringArray();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getGuid ()
    {
        return guid;
    }

    public void setGuid (String guid)
    {
        this.guid = guid;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getPubDate ()
    {
        return pubDate;
    }

    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public Enclosure getEnclosure ()
    {
        return enclosure;
    }

    public void setEnclosure (Enclosure enclosure)
    {
        this.enclosure = enclosure;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String[] getCategories ()
    {
        return categories;
    }

    public void setCategories (String[] categories)
    {
        this.categories = categories;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", guid = "+guid+", author = "+author+", pubDate = "+pubDate+", title = "+title+", thumbnail = "+thumbnail+", enclosure = "+enclosure+", description = "+description+", link = "+link+", categories = "+categories+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(content);
        parcel.writeString(guid);
        parcel.writeString(author);
        parcel.writeString(pubDate);
        parcel.writeString(title);
        parcel.writeString(thumbnail);
        parcel.writeString(description);
        parcel.writeString(link);
        parcel.writeStringArray(categories);
    }
}

			