
package com.rohmanhakim.beritaku.services.detik;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id {

    @SerializedName("account_code")
    @Expose
    public String accountCode;
    @SerializedName("idfokus")
    @Expose
    public String idfokus;
    @SerializedName("kanal_id")
    @Expose
    public String kanalId;
    @SerializedName("kanal_name")
    @Expose
    public String kanalName;
    @SerializedName("kanal_parent_id")
    @Expose
    public String kanalParentId;
    @SerializedName("kanal_parent_name")
    @Expose
    public String kanalParentName;
    @SerializedName("news_id")
    @Expose
    public String newsId;

}
