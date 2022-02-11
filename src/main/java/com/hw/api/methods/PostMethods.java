package com.hw.api.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;

import static io.restassured.RestAssured.given;

public class PostMethods {
    public Response withToken(String token, String resource, int expSC, String body) {
        RestAssured.baseURI = "https://gorest.co.in/public/v1";
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .headers(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .when()
                .body(body)
                .post(resource)
                .then()
                .assertThat()
                .statusCode(expSC)
                .extract()
                .response();
    }
}
