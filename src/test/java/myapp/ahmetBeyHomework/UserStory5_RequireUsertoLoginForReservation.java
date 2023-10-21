package myapp.ahmetBeyHomework;

import com.github.javafaker.Faker;
import myapp.pages.RentalHomePage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static myapp.utilities.BrowserUtils.getRandomDate;
import static myapp.utilities.BrowserUtils.getRandomTime;
import static org.testng.AssertJUnit.assertTrue;

public class UserStory5_RequireUsertoLoginForReservation {

//    Name:
//    Require user to login for reservation
//    Description:
//    User should see a message when user tries to book a car while not logged in
//    Acceptance Criteria:
//    As customer, I should be able to see error message, when I try to book a car while not logged in
//    Message: Please first login
//    Given user is on the login page
//    And tries to book a car
//    And click continue reservation
//    Then user see the warning message: Please first login

//    TEST CASE:

    @Test
    public void test01() {
//    The customer is on the application home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        Verify that customer on the home page
        RentalHomePage rentalHomePage = new RentalHomePage();
        assertTrue(rentalHomePage.loginLink.isDisplayed());
//        Select a car
//        BrowserUtils.dropdownSelectByVisibleText(car,"BMW i3");
        WebElement car = rentalHomePage.selectCar;
        Select select = new Select(car);
        BrowserUtils.dropdownSelectRandomText(select);
//        Pick-up
        WebElement pickup = rentalHomePage.pickUp;
        Faker faker = new Faker();
        pickup.sendKeys(faker.address().city());
        WaitUtils.waitFor(2);
//        Drop-Off
        WebElement dropoff = rentalHomePage.dropOfLocation;
        dropoff.sendKeys(faker.address().city());
        WaitUtils.waitFor(2);
//        Pick-Up Date
        WebElement pickupDate = rentalHomePage.pickUpDate;
        LocalDate randomDate = getRandomDate();
        LocalTime randomTime = getRandomTime();
        // Tarih ve Saati inputlara yaz
        pickupDate.sendKeys(randomDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

//        Pick-up Time
        WebElement pickupTime = rentalHomePage.pickUpTime;
        pickupTime.sendKeys(randomTime.format(DateTimeFormatter.ofPattern("HH:mm")));

//        DropOff Date
       WebElement dropoOffDate = rentalHomePage.dropOffDate;
       dropoOffDate.sendKeys(randomDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

//       DropOff Time
       WebElement dropOffTime = rentalHomePage.dropOffTime;
        dropOffTime.sendKeys(randomTime.format(DateTimeFormatter.ofPattern("HH:mm")));

//       Continue Reservation
        BrowserUtils.clickWithTimeOut(rentalHomePage.continueReservation,2);

//        Verify a message which is that first login
       WaitUtils.waitForVisibility(rentalHomePage.firstLogin,2);

//       Close the driver
        Driver.closeDriver();
    }



}
