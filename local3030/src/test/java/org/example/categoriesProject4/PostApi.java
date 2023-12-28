package org.example.categoriesProject4;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostApi {
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    @Test
    public void createcategory() {

        String jsonData = "{\n" +
                "  \"name\": \"laptop\",\n" +
                "  \"id\": \"145\"\n" +
                "}";

        validatableResponse = given()
                    .contentType(ContentType.JSON)
                    .body(jsonData)
                    .post("http://localhost:3030/categories")
                    .then()
                    .statusCode(201);


            System.out.println(validatableResponse.extract().asPrettyString());
        }
}
