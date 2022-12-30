package io.swagger.petstore.crudtest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.petstore.model.PetBodyDataPojo;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;


public class PetPostTest {

    public static String basePath;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet";
    }

    @Test
    public void createPet() {

        PetBodyDataPojo.CategoryData categoryData = new PetBodyDataPojo.CategoryData(101, "Dog");

        ArrayList<String> photoList = new ArrayList<>();
        photoList.add("www.pug.com/photo");

        ArrayList < PetBodyDataPojo.TagData> tagDataList = new ArrayList<>();
        PetBodyDataPojo.TagData tagData = new PetBodyDataPojo.TagData(111, "Black and White spots");
        tagDataList.add(tagData);

        PetBodyDataPojo petBodyDataPojo = new PetBodyDataPojo();
        petBodyDataPojo.setId(100);
        petBodyDataPojo.setCategory(categoryData);
        petBodyDataPojo.setName("Puggsy");
        petBodyDataPojo.setPhotoUrls(photoList);
        petBodyDataPojo.setTags(tagDataList);
        petBodyDataPojo.setStatus("Available");


        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .body(petBodyDataPojo)
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().log().all().statusCode(200);


    }
}
