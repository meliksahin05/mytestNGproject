package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentalHomePage {
//    1.Create constructor
//    2. create page objects

    public RentalHomePage (){
//        1.Create constructor
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //    2. create page objects
    @FindBy(partialLinkText = "Login")
    public WebElement loginLink;
    @FindBy(id="dropdown-basic-button")
    public WebElement userID;
    @FindBy(xpath = "//select[@name='car']")
    public WebElement selectCar;
    @FindBy(xpath = "//input[@title='Pick Up']")
    public WebElement pickUp;
    @FindBy(name = "dropOfLocation")
    public WebElement dropOfLocation;
    @FindBy(name = "pickUpDate")
    public WebElement pickUpDate;
    @FindBy(name = "pickUpTime")
    public WebElement pickUpTime;
    @FindBy(name = "dropOffDate")
    public WebElement dropOffDate;
    @FindBy(name = "dropOffTime")
    public WebElement dropOffTime;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueReservation;
    @FindBy(xpath = "//div//div//div//div//div//div[.='Please first login']")
    public WebElement firstLogin;


}

