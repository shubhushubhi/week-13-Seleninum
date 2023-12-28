package org.example.Homework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRestApi {
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    @Test
    public void createUser() {
        String jsonData = "{\n" +
                "    \"name\": \"Rajaram\",\n" +
                "    \"job\": \"Tester\"\n" +
                "}";

        validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Rajaram"))
                        .body("job", equalTo("Tester"));

        System.out.println(validatableResponse.extract().asPrettyString());
    }
}
