package io.swagger.petstore.crudtest;

import io.restassured.response.Response;
import io.swagger.petstore.model.UserPojo;
import io.swagger.petstore.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserUpdateTest extends TestBase {

    @Test
    public void updateUser(){
        UserPojo userPojo = new UserPojo();
        userPojo.setId(2);
        userPojo.setUsername("Nik1");
        userPojo.setFirstName("Nikko");
        userPojo.setLastName("Cann");
        userPojo.setEmail("nik@gmail.com");
        userPojo.setPassword("caan123");
        userPojo.setPhone("0123458765");
        userPojo.setUserStatus(1);

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .put("https://petstore.swagger.io/v2/user/Jhon1");
        response.prettyPrint();
        response.then().log().all().statusCode(200);




    }
}
