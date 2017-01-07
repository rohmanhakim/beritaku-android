
package com.rohmanhakim.beritaku.services.detik;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Authors {

    @SerializedName("editor")
    @Expose
    public String editor;
    @SerializedName("penulis")
    @Expose
    public String penulis;
    @SerializedName("reporter")
    @Expose
    public String reporter;

}
