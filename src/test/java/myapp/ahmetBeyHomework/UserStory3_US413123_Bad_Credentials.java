package myapp.ahmetBeyHomework;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class UserStory3_US413123_Bad_Credentials {

//    Name: US413123_Bad_Credentials
//    Login screen error messages
//    Description:
//    User should see error message when user tries to login with incorrect credentials
//    Acceptance Criteria:
//    As admin or customer, I should be able to see error message,
//    when I provide a correct email address BUT incorrect password in a pop up window
//    Error Message: Bad credentials

//    Test Case
    @Test
    public void US413123_Bad_Credentials(){
//    the customer is on the application home page
//        Driver.getDriver().get("https://www.bluerentalcars.com/");
//        Alternatively
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        Verify that customer on the home page
        RentalHomePage rentalHomePage = new RentalHomePage();
        assertTrue(rentalHomePage.loginLink.isDisplayed());
//    Then click on the login button
        rentalHomePage.loginLink.click();
//        Verify that customer on the login page
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        assertTrue(rentalLoginPage.username.isDisplayed());
//    Then enter correct email  and  incorrect password
//        rentalLoginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
//        rentalLoginPage.password.sendKeys(ConfigReader.getProperty("wrong_customer_password"));
//        Alternatively
        BrowserUtils.sendKeysWithTimeout(rentalLoginPage.username,ConfigReader.getProperty("admin_username"),2);
        BrowserUtils.sendKeysWithTimeout(rentalLoginPage.password,ConfigReader.getProperty("wrong_customer_password"),2);
//    Then click on the login button
        BrowserUtils.clickWithTimeOut(rentalLoginPage.loginButton,2);
//    Verify Error Message: Bad credentials
        WaitUtils.waitForVisibility(rentalLoginPage.badCredentials,3);
//        Close the driver
        Driver.closeDriver();

    }




}
