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


}

