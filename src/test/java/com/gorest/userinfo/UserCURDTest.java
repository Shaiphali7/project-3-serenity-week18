package com.gorest.userinfo;

import com.gorest.constants.EndPoints;
import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.RestRequests;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCURDTest extends TestBase {
    static String token="f7a738f583cf80ee2b5d979d410904a9def9697b4b187788353d1a3e1b0fca1e";
    static String name="shaif"+ TestUtils.getRandomValue();
    static String gender="Female";
    static String email="Prime123@gmail.com"+TestUtils.getRandomValue();
    static String status="active";

    @Title("Creating new user")
@Test
    public void test001()
    {
        UserPojo userPojo=new UserPojo();
        userPojo.setGender(gender);
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setStatus(status);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Content-Type", "application/json", new Object[]{"Authorization", "Bearer " + token})
                .when()
                .body(userPojo)
                .post()
                .then().log().all().statusCode(201);
    }
    @Title("Getting all the user")
    @Test
    public void test002()
    {
        int id= 4280508;
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Content-Type", "application/json", new Object[]{"Authorization", "Bearer " + token})
                .when()
                .get()
                .then().log().all().statusCode(200);

    }
    @Title("This will Update a new User")
    @Test
    public void verifyUserUpdatedSuccessfully() {
        int id= 4280508;

        UserPojo userpojo = new UserPojo();
        userpojo.setName("Prime");
        userpojo.setEmail(email);
        userpojo.setGender("male");

        userpojo.setStatus("active");
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Content-Type", "application/json",new Object[]{"Authorization", "Bearer " + token})
                .pathParams("id", id)
                .when()
                .body(userpojo)
                .put(EndPoints.USER_ID)
                .then().log().all().statusCode(200);

    }
    @Title("This will Delete User by ID")
    @Test

    public void deleteUser() {
               int id= 4280508;
        RestRequests.given()
                .pathParam("id", id)
                .when()
                .delete(EndPoints.USER_ID)
                .then()
                .statusCode(404);

    }
}


