
package com.rohmanhakim.beritaku.services.detik;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("authors")
    @Expose
    public Authors authors;
    @SerializedName("comment")
    @Expose
    public int comment;
    @SerializedName("data")
    @Expose
    public String data;
    @SerializedName("dateset")
    @Expose
    public Dateset dateset;
    @SerializedName("fotos")
    @Expose
    public List<Object> fotos = null;
    @SerializedName("id")
    @Expose
    public Id id;
    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("keyword")
    @Expose
    public String keyword;
    @SerializedName("livereport")
    @Expose
    public boolean livereport;
    @SerializedName("liveupdate")
    @Expose
    public boolean liveupdate;
    @SerializedName("multiplepage")
    @Expose
    public int multiplepage;
    @SerializedName("otherstory")
    @Expose
    public List<Otherstory> otherstory = null;
    @SerializedName("rating")
    @Expose
    public int rating;
    @SerializedName("relatedstory")
    @Expose
    public List<Relatedstory> relatedstory = null;
    @SerializedName("resume")
    @Expose
    public String resume;
    @SerializedName("titles")
    @Expose
    public Titles titles;
    @SerializedName("url")
    @Expose
    public String url;

}
