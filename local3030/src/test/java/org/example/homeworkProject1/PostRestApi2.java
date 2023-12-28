package org.example.homeworkProject1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRestApi2 {
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    @Test
    public void createUser() {
        String jsonData = "{\n" +
                "  \"name\": \"laptop body\",\n" +
                "  \"id\": \"acer\"\n" +
                "}";

        RestAssured.baseURI = "http://localhost:3030/categories";

        //create request specification
        requestSpecification = RestAssured.given();

        // // Setting content type to specify format in which request payload will be sent.
        requestSpecification.contentType(ContentType.JSON);

        //// Adding body as string
        requestSpecification.body(jsonData);

        //// Calling POST method
        response = requestSpecification.post();

        // // Let's print response body.
        System.out.println(response.prettyPrint());

        validatableResponse = response.then();
        // Check status code
        validatableResponse.statusCode(201);

        // Check response body - name attribute
        validatableResponse.body("name", equalTo("laptop body"));

    }
}

