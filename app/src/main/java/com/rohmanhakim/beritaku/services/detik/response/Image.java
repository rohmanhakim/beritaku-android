
package com.rohmanhakim.beritaku.services.detik;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("caption")
    @Expose
    public String caption;
    @SerializedName("cover")
    @Expose
    public String cover;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("story")
    @Expose
    public String story;
    @SerializedName("title")
    @Expose
    public String title;

}
