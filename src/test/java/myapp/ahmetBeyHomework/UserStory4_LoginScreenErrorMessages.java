package myapp.ahmetBeyHomework;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class UserStory4_LoginScreenErrorMessages {

//    Name:
//    Login screen error messages
//    Description:
//    User should see error message when an invalid email is entered
//    Acceptance Criteria:
//    As admin or customer, I should be able to see error message, when I do not provide a complete valid email address in email address box
//    Error Message: email must be a valid email
//    When I enter a valid email domain, then I should not see the error message
//    https://email-verify.my-addr.com/list-of-most-popular-email-domains.php

    @Test
    public void LoginScreenErrorMessages(){
//    the customer is on the application home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        Verify that customer on the home page
        RentalHomePage rentalHomePage = new RentalHomePage();
        assertTrue(rentalHomePage.loginLink.isDisplayed());
//    Then click on the login button
        rentalHomePage.loginLink.click();
//        Verify that customer on the login page
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        assertTrue(rentalLoginPage.email.isDisplayed());
//    Then enter invalid email  and  correct password
        rentalLoginPage.email.sendKeys("walter white");
        BrowserUtils.sendKeysWithTimeout(rentalLoginPage.password,ConfigReader.getProperty("admin_password"),2);
//    Then click on the login button
//        rentalLoginPage.loginButton.click();
        BrowserUtils.clickWithTimeOut(rentalLoginPage.loginButton,2);
        WaitUtils.waitForVisibility(rentalLoginPage.invalidEmail,2);
//    Verify Error Message: Bad credentials
        assertTrue(rentalLoginPage.invalidEmail.isDisplayed());

//        Close the driver
        Driver.closeDriver();
    }

}
