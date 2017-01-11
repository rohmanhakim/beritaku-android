
package com.rohmanhakim.beritaku.services.detik.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetikNewsItem {

    @SerializedName("date")
    @Expose
    public Date date;
    @SerializedName("editor")
    @Expose
    public String editor;
    @SerializedName("idkanal")
    @Expose
    public String idkanal;
    @SerializedName("idnews")
    @Expose
    public String idnews;
    @SerializedName("images")
    @Expose
    public Images images;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("news_type")
    @Expose
    public String newsType;
    @SerializedName("penulis")
    @Expose
    public String penulis;
    @SerializedName("reporter")
    @Expose
    public String reporter;
    @SerializedName("subtitle")
    @Expose
    public String subtitle;
    @SerializedName("summary")
    @Expose
    public String summary;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("typechannel")
    @Expose
    public String typechannel;

}
