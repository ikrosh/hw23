package com.hw.api.model;

import com.google.gson.annotations.SerializedName;

public class UserDataInfo {

    private String meta;
    @SerializedName("data")
    private UserResponse userResponse;

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
