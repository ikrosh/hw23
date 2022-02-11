package com.hw.api.requests;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;


public class UsersRequests extends BaseRequests {

    public Map<String, Object> getUsersRequest(String token, String resource) {
        Response response = getMethods
                .withToken(token, resource);
        return new HashMap<String, Object>() {
            {
                put("response", response);
                put("id", response.toString());
            }
        };
    }

    public Map<String, Object> createUserRequest(String token, String resource, int expectedStatusCode,  String body) {
        Response response = postMethods
                .withToken(token, resource, expectedStatusCode, body);
        return new HashMap<String, Object>() {
            {
                put("response", response);
                put("id", response.toString());
            }
        };
    }
}
