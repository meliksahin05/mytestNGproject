package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZBankManagerPage {

    public XYZBankManagerPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCustomerButton;
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement openAccount;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    public WebElement customers;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameInput;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement surnameInput;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCodeInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement customerSubmit;
    @FindBy(id = "userSelect")
    public WebElement selectName;
    @FindBy(id = "currency")
    public WebElement selectCurrency;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement process;


}
