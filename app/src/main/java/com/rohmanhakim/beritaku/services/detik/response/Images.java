
package com.rohmanhakim.beritaku.services.detik.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("caption")
    @Expose
    public String caption;
    @SerializedName("cover")
    @Expose
    public String cover;

}
