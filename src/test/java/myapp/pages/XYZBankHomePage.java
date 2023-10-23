package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZBankHomePage {

//    1-)Create a constructor
    public XYZBankHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


//    2. create a object
    @FindBy(xpath = "//button[.='Bank Manager Login']")
    public WebElement bankManagerLoginButton;
    @FindBy(xpath = "//button[.='Customer Login']")
    public WebElement customerLoginButton;
    @FindBy(id = "userSelect")
    public WebElement selectCustomerName;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement login;
    @FindBy(xpath= "//button[@ng-class='btnClass2']")
    public WebElement deposit;
    @FindBy(xpath = "//input[@type='number']")
    public WebElement enterAmountOfMoney;
    @FindBy(xpath = "//button[.='Home']")
    public WebElement homeSweetHome;

}
