package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(xpath = "//button[.='Home']")
    public WebElement homeSweetHome;
    @FindBy (xpath = "//button[.='Delete']")
    public List<WebElement> deleteButton;

}
