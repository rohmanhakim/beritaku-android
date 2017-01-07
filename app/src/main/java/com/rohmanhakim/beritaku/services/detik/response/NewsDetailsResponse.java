package com.rohmanhakim.beritaku.services.detik.response;

import com.google.gson.annotations.SerializedName;
import com.rohmanhakim.beritaku.services.detik.Content;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 21:52.
 */
public class NewsDetailsResponse {
    @SerializedName("content")
    public Content content;
}
