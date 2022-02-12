package com.hw.api.data;

public enum Credentials {

    TOKEN("");

    private String token;

    Credentials(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
