package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XYZBankCustomerPage {

    public XYZBankCustomerPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "userSelect")
    public WebElement selectCustomerName;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement login;
    @FindBy(xpath= "//button[@ng-class='btnClass2']")
    public WebElement deposit;
    @FindBy(xpath = "//input[@type='number']")
    public WebElement enterDepositAmountOfMoney;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitDeposit;
    @FindBy(xpath = "//span[.='Deposit Successful']")
    public WebElement successfulDeposit;
    @FindBy(xpath= "//button[@ng-class='btnClass3']")
    public WebElement withdrawbutton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement withDrawAmountOfMoney;
    @FindBy(xpath = "//button[.='Withdraw']")
    public WebElement submitWithdrawButton;
    @FindBy(xpath = "//span[.='Transaction successful']")
    public WebElement transectionMessage;
    @FindBy(xpath = "//button[.='Logout']")
    public WebElement LogoutButton;





}
