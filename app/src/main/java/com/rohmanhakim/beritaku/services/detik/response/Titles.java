
package com.rohmanhakim.beritaku.services.detik;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Titles {

    @SerializedName("subtitle")
    @Expose
    public String subtitle;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;

}
