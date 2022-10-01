package com.gorest.gorest;

import com.gorest.model.GorestUserDataPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GorestUserDataCRUDData extends TestBase {

    @Test
    public void GetAllUserData()
    {
        Response response = given()
                .when()
                .get("/public/v2/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void PostCreateNewUserData()
    {
        GorestUserDataPojo gorestUserDataPojo =new GorestUserDataPojo();
        gorestUserDataPojo.setName("Rep. Aashrit Rana11");
        gorestUserDataPojo.setEmail("rep_aashrit_rana@graham.info11");
        gorestUserDataPojo.setGender("male");
        gorestUserDataPojo.setStatus("Inactive");

        Response response = given()
                .basePath("/public/v2/users")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .body(gorestUserDataPojo)
                .when()
                .post();
        response.then().statusCode(422);
        response.prettyPrint();
    }

    @Test
    public void PatchUpdateData()
    {
        GorestUserDataPojo gorestUserDataPojo =new GorestUserDataPojo();
        gorestUserDataPojo.setName("Rep1. Aashritha Rana");
        gorestUserDataPojo.setEmail("rep1_aashritha_rana@graham.info");
        gorestUserDataPojo.setGender("male");
        gorestUserDataPojo.setStatus("active");

        Response response = given()
                .basePath("/public/v2/users")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 65cbc4c43040ae97eb012d87fb6bb928809feb842bfeba5ea49b2969ea92ede6")
                .pathParam("id","3424")
                .body(gorestUserDataPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void deleteUserData() {
        Response response = given()
                .basePath("/public/v2/users")
                .pathParam("id","3420")
                .when()
                .delete("/{id}");
        response.then().statusCode(401);
        response.prettyPrint();

    }
}
