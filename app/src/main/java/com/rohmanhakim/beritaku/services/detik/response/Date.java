
package com.rohmanhakim.beritaku.services.detik.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date {

    @SerializedName("created")
    @Expose
    public String created;
    @SerializedName("created_timestamp")
    @Expose
    public String createdTimestamp;
    @SerializedName("publish")
    @Expose
    public String publish;
    @SerializedName("publish_timestamp")
    @Expose
    public String publishTimestamp;

}
