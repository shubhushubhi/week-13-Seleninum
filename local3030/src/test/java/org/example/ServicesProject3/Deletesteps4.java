package org.example.ServicesProject3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Deletesteps4 {
    RequestSpecification requestSpecification;
    Response response;
    ResponseSpecification responseSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void deleteUser(){
        RestAssured.baseURI ="http://localhost:3030/services/6";
        requestSpecification = given();
        response=requestSpecification.delete();
        System.out.println(response.prettyPrint());

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        // validatableResponse.body("message", equalTo("Successfully! Record has been deleted"));
  }
}

