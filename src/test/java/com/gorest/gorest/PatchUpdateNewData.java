package com.gorest.gorest;

import com.gorest.model.GorestUserDataPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchUpdateNewData extends TestBase {

        @Test
        public void PatchUpdateData()
        {
            GorestUserDataPojo gorestUserDataPojo =new GorestUserDataPojo();
            gorestUserDataPojo.setName("Rep1. Aashritha Rana");
            gorestUserDataPojo.setEmail("rep1_aashritha_rana@graham.info");
            gorestUserDataPojo.setGender("male");
            gorestUserDataPojo.setStatus("inactive");

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
}
