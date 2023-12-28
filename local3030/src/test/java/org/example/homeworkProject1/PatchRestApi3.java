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

public class PatchRestApi3 {
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    @Test
    public void patchuser() {
        String jsonData = " {\n" +
                "        \"name\": \"computer\",\n" +
                "            \"type\": \"string\",\n" +
                "            \"price\": 0,\n" +
                "            \"shipping\": 0,\n" +
                "            \"upc\": \"string\",\n" +
                "            \"description\": \"string\",\n" +
                "            \"manufacturer\": \"Acer\",\n" +
                "            \"model\": \"string\",\n" +
                "            \"url\": \"string\",\n" +
                "            \"image\": \"string\"\n" +
                "    }";

        RestAssured.baseURI = "http://localhost:3030/products/43900";

        //create request specification
        requestSpecification = given();

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonData);

        response = requestSpecification.patch();

        System.out.println(response.prettyPrint());

        validatableResponse = response.then();

        validatableResponse.statusCode(200);

        validatableResponse.body("type", equalTo("string"));
    }


}

