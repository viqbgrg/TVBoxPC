package com.github.viqbgrg.tvbox.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Result {
    @SerializedName("class")
    private List<Class> types;
    @SerializedName("list")
    private List<Vod> list;
}
