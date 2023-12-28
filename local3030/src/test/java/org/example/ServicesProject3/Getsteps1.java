package org.example.ServicesProject3;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Getsteps1 {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllEmployees() {

        given().log().all()
                .when()
                .get("http://localhost:3030/services")
                .then().log().all()
                .statusCode(200);

    }
    @Test
    public void getproductById(){
        given().log().all()
                .when()
                .get("http://localhost:3030/stores/6")
                .then().log().all()
                .statusCode(200);
    }
}

