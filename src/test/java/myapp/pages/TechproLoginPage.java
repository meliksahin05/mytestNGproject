package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechproLoginPage {
//    1.Create a constructor
//    2. create a object

     public TechproLoginPage(){

//    1.Create a constructor
         PageFactory.initElements(Driver.getDriver(), this);
     }

     @FindBy(id = "exampleInputEmail1")
    public WebElement username;
     @FindBy(id = "exampleInputPassword1")
    public WebElement password;
     @FindBy(xpath = "//button[@type='submit']")
    public WebElement login;




}
