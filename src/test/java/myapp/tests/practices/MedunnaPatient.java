package myapp.tests.practices;

import com.github.javafaker.Faker;
import myapp.pages.MedunnaHomePage;
import myapp.pages.MedunnaLoginPage;
import myapp.pages.MedunnaPatientPage;
import myapp.utilities.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MedunnaPatient {



    @Test(dataProvider = "medunnaCredentials", dataProviderClass = DataProviderUtils.class)
    public void medunnaPatient(String username, String password, String firstname, String lastname, String email, String phone) {
//        Go to https://medunna.com/

        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

//        Click on "user icon"
        MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
        medunnaHomePage.userIcon.click();

//        Click on "Sign In" option
        medunnaHomePage.signInOption.click();
//        Enter username into "Username" input
        MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();
        medunnaLoginPage.userName.sendKeys(username);
//        Enter password into "Password" input
        medunnaLoginPage.passwordInput.sendKeys(password);

//        Click on "Remember me" check box
        medunnaLoginPage.rememberMeCheckbox.click();
        assertTrue(medunnaLoginPage.rememberMeCheckbox.isSelected());

//        Click on "Sign in" submit button
        medunnaLoginPage.signInSubmitButton.click();

//        Click on "Items&Titles" menu
         medunnaHomePage.itemsAndTitlesMenu.click();

//        Click on "Patient" option
        medunnaHomePage.patientOption.click();

//        Click on "Create a new patient" button
        medunnaLoginPage.createANewPatientLink.click();

//        Enter firstname into "First Name" input
        Faker faker = new Faker();
        MedunnaPatientPage medunnaPatientPage = new MedunnaPatientPage();
        medunnaPatientPage.firstName.sendKeys(firstname);

//        Enter lastname into "Last Name" input
        medunnaPatientPage.lastName.sendKeys(lastname);

//        Enter email into "Email" input
        medunnaPatientPage.mailInput.sendKeys(faker.number().numberBetween(1000,9999)+email); //to make email unique in each run, we use faker

//        Enter phone number into "Phone" input
        phone = phone.replaceAll("[^0-9]","");
        medunnaPatientPage.phoneInput.sendKeys(phone);

////      gender
//        Select selectGender = new Select(medunnaPatientPage.genderDropdown);
//        selectGender.selectByValue("MALE");
//
////      blood
//        Select selectBlood = new Select(medunnaPatientPage.bloodGroupDropDown);
//        selectBlood.selectByIndex(6);
//
////      patient address
//        medunnaPatientPage.address.sendKeys(faker.address().fullAddress());
//
////      description
//        medunnaPatientPage.description.sendKeys(faker.harryPotter().quote());
//
//


//        Click on "Save" button
//        medunnaPatientPage.saveSubmitButton.click();
//       We got this issue "ElementClickInterceptedException: element click intercepted: Element is not clickable at point"
        JSUtils.JSclickWithTimeout(medunnaPatientPage.saveSubmitButton);//Since Selenium click did not work.// We click with JS Executor

//        Assert that patient is created
        WaitUtils.waitForVisibility(medunnaHomePage.alertMessage,3);
         assertTrue(medunnaHomePage.alertMessage.getText().contains("A new Patient is created with identifier"));

//      close Driver because you didnt signout so when first person registered, driver can not move to second person
        Driver.closeDriver();


    }

}