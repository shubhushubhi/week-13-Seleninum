package org.example.ServicesProject3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Poststep2 {
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    @Test
    public void createUser() {
        String jsonData = "{\n" +
                "  \"name\": \"Testing\"\n" +
                "}";

        validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("http://localhost:3030/services")
                .then()
                .statusCode(201)
                .body("name", equalTo("Testing"));
        System.out.println(validatableResponse.extract().asPrettyString());
    }

}


