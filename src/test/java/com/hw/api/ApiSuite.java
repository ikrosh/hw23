package com.hw.api;

import com.hw.api.model.UserDataInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiSuite extends BaseTest {

    @Test
    public void getUsersTest() {
        Map<String, Object> mapUsers = usersRequests
                .getUsersRequest("5f6f356d11a529da54c3c84ef937c1e5997cdb7f3f74faed56623dc0dd541f42",
                        "/users");
        Response response = (Response) mapUsers.get("response");
        assertThat(response.contentType()).as("").isEqualTo("application/json; charset=utf-8");
    }

    @Test
    public void createUserTest() {
        final String random = RandomStringUtils.randomAlphabetic(3);
        String user =  "{"
        + "                \"name\": \"Helen M Lewis" + random + "\","
        + "                \"gender\" : \"female\","
        + "                \"email\" : \"HelenMLewis" + random + "@rhyta.com\","
        + "                \"status\": \"inactive\""
        + "        }";
        Map<String, Object> mapUsers = usersRequests
                .createUserRequest("5f6f356d11a529da54c3c84ef937c1e5997cdb7f3f74faed56623dc0dd541f42",
                        "/users", 201, user);
        Response response = (Response) mapUsers.get("response");
        assertThat(response.contentType()).as("").isEqualTo("application/json; charset=utf-8");
        UserDataInfo userDataInfo = gson.fromJson(response.asString(), UserDataInfo.class);
        assertThat(userDataInfo.getUserResponse().getName()).as("").isEqualTo("Helen M Lewis" + random);
        assertThat(userDataInfo.getUserResponse().getEmail()).as("").isEqualTo("HelenMLewis" + random + "@rhyta.com");
    }

}