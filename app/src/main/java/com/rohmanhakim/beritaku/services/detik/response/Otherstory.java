
package com.rohmanhakim.beritaku.services.detik;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Otherstory {

    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("datecreated")
    @Expose
    public String datecreated;
    @SerializedName("idberita")
    @Expose
    public String idberita;
    @SerializedName("idkanal")
    @Expose
    public String idkanal;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("parentkanal")
    @Expose
    public String parentkanal;
    @SerializedName("sitename")
    @Expose
    public String sitename;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;

}
