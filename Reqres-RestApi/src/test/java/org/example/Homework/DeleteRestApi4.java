package org.example.Homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteRestApi {
    RequestSpecification requestSpecification;
    Response response;
    ResponseSpecification responseSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void deleteUser() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        requestSpecification = given();
        response = requestSpecification.delete();
        System.out.println(response.prettyPrint());

        validatableResponse = response.then();
        validatableResponse.statusCode(204);
        validatableResponse.body("message", equalTo("Successfully! Record has been deleted"));
    }
}