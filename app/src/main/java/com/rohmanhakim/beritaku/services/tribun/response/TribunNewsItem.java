
package com.rohmanhakim.beritaku.services.tribun.response;

import com.google.gson.annotations.SerializedName;

public class TribunNewsItem {

    @SerializedName("title")
    public String title;

    @SerializedName("link")
    public String link;

    @SerializedName("photo")
    public String photo;

    @SerializedName("thumb")
    public String thumb;

    @SerializedName("description")
    public String description;

    @SerializedName("pubDate")
    public String pubDate;

    @SerializedName("date")
    public String date;

    @SerializedName("guid")
    public String guid;

    @SerializedName("topic")
    public Object topic;

    @SerializedName("topic_url")
    public Object topicUrl;

    @SerializedName("topic_guid")
    public Object topicGuid;

    @SerializedName("section_title")
    public String sectionTitle;

    @SerializedName("section_url")
    public String sectionUrl;

    @SerializedName("section_guid")
    public String sectionGuid;

}
