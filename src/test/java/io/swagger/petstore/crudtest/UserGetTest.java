package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserGetTest extends TestBase {

    @Test

    public void getUser(){

        Response response = given()
                .when()
                .pathParam("username", "Nik1")
                .get("{username}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
