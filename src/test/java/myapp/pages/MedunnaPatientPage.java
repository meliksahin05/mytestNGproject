package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedunnaPatientPage {

    public MedunnaPatientPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "firstName")
    public WebElement firstName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(id = "patient-birthDate")
    public WebElement birthDate;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement mailInput;

    @FindBy (xpath = "//input[@name='phone']")
    public WebElement phoneInput;

    @FindBy(id = "patient-gender")
    public WebElement genderDropdown;

    @FindBy(name = "bloodGroup")
    public WebElement bloodGroupDropDown;

    @FindBy(id = "patient-adress")
    public WebElement address;

    @FindBy(id = "patient-description")
    public  WebElement description;

    @FindBy(name = "user.id")
    public WebElement userDropdown;

    @FindBy (id = "patient-country")
    public WebElement countryDropDown;


    @FindBy(id = "save-entity")
    public WebElement saveSubmitButton;









}
