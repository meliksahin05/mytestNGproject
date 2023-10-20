package myapp.ahmetBeyHomework;

import myapp.pages.TechproHomePage;
import myapp.pages.TechproLoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TechproLoginTest {

//    https://testcenter.techproeducation.com/index.php?page=form-authentication
//    Test the Login  and logout functionality of the application using page object model

    @Test
    public void loginTest() throws InterruptedException {
//        get the page
        Driver.getDriver().get("https://testcenter.techproeducation.com/index.php?page=form-authentication");
//        login the page
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        techproLoginPage.username.sendKeys("techproed");
        WaitUtils.waitFor(3);
        techproLoginPage.password.sendKeys("SuperSecretPassword");
        WaitUtils.waitFor(3);
        techproLoginPage.login.click();
        WaitUtils.waitFor(3);
//        verify that you are on the home page
        TechproHomePage techproHomePage = new TechproHomePage();
        Assert.assertTrue(techproHomePage.header.isDisplayed());
//        logout from the page

        techproHomePage.logout.click();
//        verify that you clicked the logout
         assertTrue(techproLoginPage.username.isDisplayed());

//         close the driver
        Driver.closeDriver();
    }

    @Test
    public void withReasubleMethodLoginTest(){
        //        get the page
        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));
        //        login the page
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        BrowserUtils.sendKeysWithTimeout(techproLoginPage.username,ConfigReader.getProperty("techpro_test_username"),3);
        BrowserUtils.sendKeysWithTimeout(techproLoginPage.password,ConfigReader.getProperty("techpro_test_password"),3);
        BrowserUtils.clickWithTimeOut(techproLoginPage.login,3);
//        verify that you are on the home page
        TechproHomePage techproHomePage = new TechproHomePage();
        BrowserUtils.verifyElementDisplayed(techproHomePage.header);
//        logout from the page
        BrowserUtils.clickWithTimeOut(techproHomePage.logout,3);
//        verify that you clicked the logout
        BrowserUtils.verifyElementDisplayed(techproLoginPage.password);
//        close the driver
        Driver.closeDriver();






    }



}
