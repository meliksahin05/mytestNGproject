package myapp.ahmetBeyHomework;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

public class UserStory2_US100208_Negative_Login {

//    Name:US100208_Negative_Login
//    Description:
//    User should not be able login with incorrect credentials
//    Acceptance Criteria:
//    As customer, I should not be able to log in the application
//    incorrect username incorrect password
//    Customer email: fake@bluerentalcars.com Customer password: fakepass
//    Error: User with email fake@bluerentalcars.com not found

//    Test Case
//    the customer is on the application home page
//    Then click on the login button
//    Then enter email  and password
//    Then click on the login button
//    Verify User with email fake@bluerentalcars.com not found
    @Test
    public void US100208_Negative_Login(){
//        the customer is on the application home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        Verify that customer on the home page
        RentalHomePage rentalHomePage = new RentalHomePage();
        BrowserUtils.verifyElementDisplayed(rentalHomePage.loginLink);
//        Then click on the login button
        BrowserUtils.clickWithTimeOut(rentalHomePage.loginLink,2);
//        Verify that customer on the login page
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        BrowserUtils.verifyElementDisplayed(rentalLoginPage.username);
//        Then enter email and password
        BrowserUtils.sendKeysWithTimeout(rentalLoginPage.username,ConfigReader.getProperty("customer_username"),2);
        BrowserUtils.sendKeysWithTimeout(rentalLoginPage.password,ConfigReader.getProperty("customer_password"), 2);
//        Then click on the login button
        BrowserUtils.clickWithTimeOut(rentalLoginPage.loginButton,2);
//        Verify User with email fake@bluerentalcars.com not found
        WaitUtils.waitFor(2);
        BrowserUtils.verifyElementDisplayed(rentalLoginPage.popUpForWrongEmail);
//        close the driver
        Driver.closeDriver();





    }

}

