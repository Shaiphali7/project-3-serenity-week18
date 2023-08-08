package com.gorest.userinfo;

import com.gorest.constants.EndPoints;
import com.gorest.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.RestRequests;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSteps{
   static String token="f7a738f583cf80ee2b5d979d410904a9def9697b4b187788353d1a3e1b0fca1e";
   @Step("Creating user with name : {0}, email : {1}, gender : {2} and status : {3}")
        public ValidatableResponse createUser(String name, String email, String gender, String status) {

            UserPojo userPojo = new UserPojo();
              userPojo.setName(name);
            userPojo.setEmail(email);
            userPojo.setGender(gender);
            userPojo.setStatus(status);
           return SerenityRest.given()
                    .headers("Content-Type", "application/json", new Object[]{"Authorization", "Bearer " + token})
                    .when()
                    .body(userPojo)
                    .post()
                    .then();

        }
        @Step("Getting all user")
    public ValidatableResponse getUser()
        {
            int id= 4278501;
           return SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .headers("Content-Type", "application/json", new Object[]{"Authorization", "Bearer " + token})
                    .when()
                    .get()
                    .then();
        }
    @Step("Creating user with name : {0}, email : {1}, gender : {2}  status : {3} and id: {4}")
    public void verifyUserUpdatedSuccessfully(String name, String email, String gender, String status,int id) {


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

    @Step("Deleting the user data by id: {0}")

    public ValidatableResponse deleteUser(int id) {

       return RestRequests.given()
                .pathParam("id", id)
                .when()
                .delete(EndPoints.USER_ID)
                .then();

    }
    }