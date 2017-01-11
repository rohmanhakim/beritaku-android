
package com.rohmanhakim.beritaku.services.tribun.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Latest {

    @SerializedName("@attributes")
    public Attributes attributes;

    @SerializedName("item")
    public List<TribunNewsItem> item = null;

}
