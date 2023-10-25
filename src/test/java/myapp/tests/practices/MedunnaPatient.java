package myapp.tests.practices;

import myapp.pages.MedunnaHomePage;
import myapp.pages.MedunnaLoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
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

//        Enter firstname into "First Name" input

//        Enter lastname into "Last Name" input

//        Enter email into "Email" input

//        Enter phone number into "Phone" input

//        Click on "Save" button

//        Assert that patient is created

    }

}