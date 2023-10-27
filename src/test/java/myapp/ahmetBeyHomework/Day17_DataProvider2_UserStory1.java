package myapp.ahmetBeyHomework;

import myapp.pages.DataTablesPage;
import myapp.utilities.DataProviderUtils;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day17_DataProvider2_UserStory1 {
    DataTablesPage dataTablesPage;
    ExcelUtils excelUtils;//to access ExcelUtils objects and methods

    @Test(dataProvider = "dataTablesData", dataProviderClass = DataProviderUtils.class)
    public void userCreationTest(String first_name,
                                 String last_name,
                                 String position,
                                 String office,
                                 String extension,
                                 String start_date,
                                 String salary){

//        When user go to  https://editor.datatables.net/
            Driver.getDriver().get("https://editor.datatables.net/");
//        Click on the new button
            DataTablesPage dataTablesPage = new DataTablesPage();
            dataTablesPage.newButton.click();
//        When user enters all fields

            dataTablesPage.firstName.sendKeys(first_name);
            WaitUtils.waitFor(2);
            dataTablesPage.lastName.sendKeys(last_name);
            WaitUtils.waitFor(2);
            dataTablesPage.position.sendKeys(position);
            WaitUtils.waitFor(2);
            dataTablesPage.office.sendKeys(office);
            WaitUtils.waitFor(2);
            dataTablesPage.extension.sendKeys(extension);
            WaitUtils.waitFor(2);
            dataTablesPage.start_date.sendKeys(start_date);
            WaitUtils.waitFor(2);
            dataTablesPage.salary.sendKeys(salary);
            WaitUtils.waitFor(2);

//        When clicks create button
            dataTablesPage.createButton.click();
            WaitUtils.waitFor(2);
//        And search for the first name
            dataTablesPage.searchBox.sendKeys(first_name);
            WaitUtils.waitFor(2);
//        Then verify the name fields contains first name
            Assert.assertTrue(dataTablesPage.nameField.getText().contains(first_name));
            WaitUtils.waitFor(2);
            Driver.closeDriver();

    }
}
