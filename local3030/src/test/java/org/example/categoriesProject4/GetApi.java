package org.example.categoriesProject4;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetApi {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllId() {

        given().log().all()
                .when()
                .get("http://localhost:3030/categories")
                .then().log().all()
                .statusCode(200);

    }
    @Test
    public void getproductById(){
        given().log().all()
                .when()
                .get("http://localhost:3030/categories/abcat0010000")
                .then().log().all()
                .statusCode(200);
    }
}
