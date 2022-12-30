package io.swagger.petstore.crudtest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.petstore.model.PetPojoNew;
import io.swagger.petstore.model.UserPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PetUpdateTest extends TestBase {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";
    }
    @Test
    public void updateUser(){
        UserPojo userPojo = new UserPojo();
        PetPojoNew petPojoNew = new PetPojoNew();

        petPojoNew.setId("1122334457");
        petPojoNew.setName("Dog");
        petPojoNew.setName("Husky");
        petPojoNew.setPhotoUrls("http://swagger.io");
        petPojoNew.setName("Sky");
        petPojoNew.setStatus(String.valueOf(0));

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().log().all().statusCode(200);




    }
}
