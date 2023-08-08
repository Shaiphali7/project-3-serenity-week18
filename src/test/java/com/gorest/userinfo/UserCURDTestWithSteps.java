package com.gorest.userinfo;

import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCURDTestWithSteps extends TestBase {
    static String token="f7a738f583cf80ee2b5d979d410904a9def9697b4b187788353d1a3e1b0fca1e";
    static String name="shaif"+ TestUtils.getRandomValue();
    static String gender="Female";
    static String email="Prime123@gmail.com"+TestUtils.getRandomValue();
    static String status="active";
    static int id= 4278501;
    @Steps
UserSteps userSteps;

    @Test
    public void test001()
    {
      userSteps.createUser(name,email,gender,status).statusCode(201);
    }
    @Title("Getting all the user")
    @Test
    public void test002()
    {
        userSteps.getUser().statusCode(200);

    }
    @Title("This will Update a new User")
    @Test
    public void verifyUserUpdatedSuccessfully() {
        
        String name1="new name";

        userSteps.verifyUserUpdatedSuccessfully(name1,email,gender,status,id);

    }
    @Title("This will Delete User by ID")
    @Test

    public void deleteUser() {

       userSteps.deleteUser(id);

    }

}
