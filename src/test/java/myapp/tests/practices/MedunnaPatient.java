package myapp.tests.practices;

import com.github.javafaker.Faker;
import myapp.pages.MedunnaHomePage;
import myapp.pages.MedunnaLoginPage;
import myapp.pages.MedunnaPatientPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MedunnaPatient {

    @Test
    public void medunnaPatient() {
//        Go to https://medunna.com/

        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

//        Click on "user icon"
        MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
        medunnaHomePage.userIcon.click();

//        Click on "Sign In" option
        medunnaHomePage.signInOption.click();
//        Enter username into "Username" input
        MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();
        medunnaLoginPage.userName.sendKeys("mark_twain");
//        Enter password into "Password" input
        medunnaLoginPage.passwordInput.sendKeys("Mark.123");

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
        medunnaPatientPage.firstName.sendKeys(faker.name().firstName());

//        Enter lastname into "Last Name" input
        medunnaPatientPage.lastName.sendKeys(faker.name().lastName());

//        Enter email into "Email" input
        medunnaPatientPage.mailInput.sendKeys(faker.internet().emailAddress());

//        Enter phone number into "Phone" input
        medunnaPatientPage.phoneInput.sendKeys(faker.phoneNumber().cellPhone());

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
         assertTrue(medunnaHomePage.alertMessage.getText().contains("A new Patient is created with identifier"));

    }

}