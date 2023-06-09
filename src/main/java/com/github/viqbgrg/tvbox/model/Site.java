package com.github.viqbgrg.tvbox.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Site {

    @SerializedName("key")
    private String key;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private Integer type;
    @SerializedName("api")
    private String api;
    @SerializedName("playUrl")
    private String playUrl;
    @SerializedName("playerType")
    private Integer playerType;
    @SerializedName("searchable")
    private Integer searchable;
    @SerializedName("filterable")
    private Integer filterable;
    @SerializedName("changeable")
    private Integer changeable;
    @SerializedName("ext")
    private String ext;
    @SerializedName("jar")
    private String jar;
    @SerializedName("categories")
    private List<String> categories;

    private boolean activated;

}
