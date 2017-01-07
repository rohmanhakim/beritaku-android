package com.rohmanhakim.beritaku.services.detik.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 1/7/17 17:06.
 */
public class NewsfeedResponse {
    @SerializedName("account_code")
    public String accountCode;

    @SerializedName("item")
    public List<Item> item;

    @SerializedName("last_date")
    public String lastDate;

    @SerializedName("lipsus")
    public Lipsus lipsus;

    @SerializedName("metadata")
    public Metadata metadata;
}
