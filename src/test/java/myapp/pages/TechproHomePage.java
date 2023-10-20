package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechproHomePage {

//    1.Create a constructor
//    2. create a object


    public TechproHomePage(){
//        1.Create a constructor
        PageFactory.initElements(Driver.getDriver(), this);

    }

//    2. create a object
     @FindBy(linkText = "Automation Engineer Applications")
    public WebElement header;
    @FindBy(partialLinkText = "Logout")
    public WebElement logout;

}
