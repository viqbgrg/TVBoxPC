package com.github.viqbgrg.tvbox.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Class {

    @SerializedName("type_id")
    private String typeId;

    @SerializedName("type_name")
    private String typeName;

    @SerializedName("type_flag")
    private String typeFlag;

    private Boolean filter;
    private boolean activated;

}
