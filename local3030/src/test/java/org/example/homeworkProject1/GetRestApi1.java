package org.example.homeworkProject1;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRestApi1 {

        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;

        @Test
        public void getAllEmployeesWay1() {

            given().log().all()
                    .when()
                    .get("http://localhost:3030/products")
                    .then().log().all()
                    .statusCode(200);

 }
        @Test
        public void getproductById(){
                given().log().all()
                        .when()
                        .get("http://localhost:3030/products/43900")
                        .then().log().all()
                        .statusCode(200);
        }
}
