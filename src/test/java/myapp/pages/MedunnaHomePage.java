package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedunnaHomePage {

    public MedunnaHomePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement userIcon;

    @FindBy(id = "login-item")
    public WebElement signInOption;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(id = "entity-menu")
    public WebElement itemsAndTitlesMenu;

    @FindBy(linkText = "patient")
    public WebElement patientOption;





}
