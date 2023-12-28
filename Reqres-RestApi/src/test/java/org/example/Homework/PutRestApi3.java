package org.example.Homework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutRestApi3 {
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    @Test
    public void updateEmployeeBdd() {

        String jsonData = "{\n" +
                "    \"name\": \"Rajaram\",\n" +
                "    \"job\": \"Tester\",\n" +
                "    \"id\": \"763\",\n" +
                "    \"createdAt\": \"2023-12-26T19:05:36.816Z\"\n" +
                "}";

        given()
                .baseUri("https://reqres.in/api/users/2")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .put()
                .then().statusCode(200)
                .body("name", equalTo("Rajaram"))
        .body("job", equalTo("Tester"))
        .body("createdAt", equalTo("2023-12-26T19:05:36.816Z"));
    }
}
