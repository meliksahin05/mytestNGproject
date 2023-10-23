package myapp.tests.practices;

import com.github.javafaker.Faker;
import myapp.pages.XYZBankHomePage;
import myapp.pages.XYZBankManagerPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class XYZBankTest {



//Open 5 new  Accounts,
// deposit 100 USD and withdraw 100 USD from any account
// and delete all accounts you created on https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login.

    @Test
    public void xyzBankTest() {

//        Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("xyz_Bank_url"));

//        Click on "Bank Manager Login" button
        XYZBankHomePage xyzBankHomePage = new XYZBankHomePage();
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.addCustomerButton.click();

//        Fill inputs and click on "Add Customer" submit button
        Faker faker = new Faker();
        for (int i = 0; i < 5; i++) {
            xyzBankManagerPage.firstNameInput.clear();
            xyzBankManagerPage.firstNameInput.sendKeys(faker.name().firstName());
            xyzBankManagerPage.surnameInput.clear();
            xyzBankManagerPage.surnameInput.sendKeys(faker.name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankManagerPage.customerSubmit.click();

//        Accept alert
//        Add 4 more customers
            Driver.getDriver().switchTo().alert().accept();
        }

//        Click on "Open Account"  button
        xyzBankManagerPage.openAccount.click();

//        Click on "Customer" dropdown

//        Select customer name
        WebElement customer = xyzBankManagerPage.selectName;
        Select selectCustomer = new Select(customer);
        for (int i = 0; i <5 ; i++) {


            selectCustomer.selectByIndex(i+6);

//        Click on "Currency" dropdown
//        Select "Dollar"
            WebElement currency = xyzBankManagerPage.selectCurrency;
            Select selectCurrency = new Select(currency);
            selectCurrency.selectByVisibleText("Dollar");

//        Click on "Process" button
            xyzBankManagerPage.process.click();

//        Accept alert
//        Open 4 more accounts
            Driver.getDriver().switchTo().alert().accept();
        }
//        Click on "Customers" button
          xyzBankManagerPage.customers.click();
//        Count table row numbers

        List<WebElement> allrow = Driver.getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']//tr"));
//        int numberofRow =-6;
//        for (WebElement eachRow:allrow) {
//            numberofRow++;
//
//        }
////        Assert that you created 5 customers
//         assertTrue(numberofRow==5);

//        ******ALTERNATIVELY AND MORE DYNAMIC******
        for (int i = allrow.size()-1; i < allrow.size()-6 ; i--) {
            boolean isBlank =allrow.get(i).getText().isBlank();
            assertFalse(isBlank);

        }
//        Click on "Home" button
        xyzBankHomePage.homeSweetHome.click();
//        Click on "Customer Login" button
        xyzBankHomePage.customerLoginButton.click();
//        Click on "Your Name" dropdown
//        Select the any name you created
        WebElement selectCustomerName = xyzBankHomePage.selectCustomerName;
        Select selectedCustomerName = new Select(selectCustomerName);
        selectedCustomerName.selectByIndex(6);
//        Click on "Login" button
        xyzBankHomePage.login.click();
//        Click on "Deposit" button
        xyzBankHomePage.deposit.click();
//        Type 100 into "Amount to be Deposited" input

//        Click on "Deposit"(Submit) button
//        Then
//        Assert that "Deposit Successful" is displayed
//        And
//        Click on "Withdrawal" button
//                And
//        Type 100 into "Amount to be Withdrawn" input
//                And
//        Click on "Withdraw"(Submit) button
//        Then
//        Assert that "Transaction  Successful" is displayed
//        When
//        Click on "Logout" button
//                And
//        Click on "Home" button
//                And
//        Click on "Bank Manager Login" button
//                And
//        Click on "Customers" button
//                And
//        Click on each "Delete" button
//                And
//        Count table row numbers
//        Then
//        Assert that number of customers is 0


        }

}
