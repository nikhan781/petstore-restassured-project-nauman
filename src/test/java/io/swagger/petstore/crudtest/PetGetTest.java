package io.swagger.petstore.crudtest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.petstore.testbase.TestBase;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PetGetTest extends TestBase {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";
    }
    @Test

    public void getUser(){

        Response response = given()
                .pathParam("id", 100)
                .when()
                .get("{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
