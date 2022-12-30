package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {

    @Test

    public void deleteUser() {

        Response response = given()
                .when()
                .pathParam("username", "Nik1")
                .delete("{username}");

        response.then().statusCode(200);
        response.prettyPrint();
    }
}