
package com.rohmanhakim.beritaku.services.detik.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("limit")
    @Expose
    public int limit;
    @SerializedName("page")
    @Expose
    public int page;
    @SerializedName("total")
    @Expose
    public int total;
    @SerializedName("total_page")
    @Expose
    public int totalPage;

}
