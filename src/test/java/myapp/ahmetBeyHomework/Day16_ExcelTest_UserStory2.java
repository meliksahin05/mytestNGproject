package myapp.ahmetBeyHomework;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class Day16_ExcelTest_UserStory2 {

    ExcelUtils excelUtils;
    List<Map<String, String>> dataList;

    @Test
    public void Test() {

        String path = "./resources/data_sheet.xlsx";
        excelUtils = new ExcelUtils(path, "employee_credentials");
        dataList = excelUtils.getDataList();


//        STORY NAME: User should be able to login as an employee profile AC:
//        Given user is on the application
//        And enter correct username and password Then verify the login is successful
//        LINK: https://www.bluerentalcars.com/
//        TEST CASE 1:
//        Test the log in functionality of the application with different user profiles(admin, manager, customer services, end user)
//        Test Data URL : https://www.bluerentalcars.com/ User Credentials : Excel Sheet

//        Start TO Loops

        for (Map<String, String> eachData : dataList) {

            System.out.println(eachData);


//        go to  the website
            Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

//        Click on the login
            RentalHomePage rentalHomePage = new RentalHomePage();
            rentalHomePage.loginLink.click();
//        Enter the email address
            RentalLoginPage rentalLoginPage = new RentalLoginPage();
            rentalLoginPage.email.sendKeys(eachData.get("username"));

//        Enter the password
            rentalLoginPage.password.sendKeys(eachData.get("password"));

//        click login button
            rentalLoginPage.loginButton.click();

//        Verify the login successful
            assertTrue(rentalHomePage.loginSuccessful.getText().contains("Customer Services"));

//        Close the driver
            Driver.closeDriver();
        }
    }

}



