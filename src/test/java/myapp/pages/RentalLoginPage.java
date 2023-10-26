package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentalLoginPage {
//    1.Create constructor
//    2. create page objects

    public RentalLoginPage(){

//    1.Create constructor
        PageFactory.initElements(Driver.getDriver(),this);
    }
//    2. create page objects
    @FindBy(id = "formBasicEmail")
    public WebElement email;
    @FindBy(id="formBasicPassword")
    public WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(className = "Toastify__toast-body")
    public WebElement popUpForWrongEmail;
    @FindBy (className = "Toastify__toast-body")
    public  WebElement badCredentials;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement invalidEmail;



}
