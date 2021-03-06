package com.hw.api.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetMethods {

   public Response withToken(String token, String resource) {
       RestAssured.baseURI = "https://gorest.co.in/public/v1";
       return given()
           .auth().oauth2(token)
           .when()
           .get(resource)
           .then()
           .assertThat()
           .statusCode(200)
           .extract()
           .response();
        }

    }
