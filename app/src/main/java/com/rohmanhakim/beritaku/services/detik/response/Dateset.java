
package com.rohmanhakim.beritaku.services.detik;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dateset {

    @SerializedName("created")
    @Expose
    public String created;
    @SerializedName("created_original")
    @Expose
    public String createdOriginal;
    @SerializedName("created_timestamp")
    @Expose
    public int createdTimestamp;
    @SerializedName("label")
    @Expose
    public String label;
    @SerializedName("publish_original")
    @Expose
    public String publishOriginal;
    @SerializedName("type")
    @Expose
    public String type;

}
