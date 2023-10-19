package myapp.tests.topics;

import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.Driver;
import myapp.utilities.MediaUtils;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class Day15_OrangeHRMLogin {

//    Automate login functionality the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login  using page object model
//    Given user is the application login page
//    Then enter the credentials
//    Then verify the login in successful
//    And logout the application
//    Then verify the logout is successful

    @Test
    public void  loginTest() throws IOException {
        //    Given user is the application login page
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    Then enter the credentials click on login button
        /*
        NOTE: I need to access the page objects
        To do this, create that page objects
         */
        OrangeHRM_LoginPage orangeHRMLoginPage = new OrangeHRM_LoginPage();
        orangeHRMLoginPage.username.sendKeys("Admin");
        WaitUtils.waitFor(2);
        orangeHRMLoginPage.password.sendKeys("admin123");
        WaitUtils.waitFor(2);
        orangeHRMLoginPage.loginButton.click();
        WaitUtils.waitFor(2);


//        ALTERNATIVELY WE CAN USE THE REUSABLE login METHOD
         orangeHRMLoginPage.login("Admin","admin123");


//    Then verify the login in successful

//    And logout the application
//    Then verify the logout is successful
    }

}
