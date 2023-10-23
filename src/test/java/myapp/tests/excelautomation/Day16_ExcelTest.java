package myapp.tests.excelautomation;

import myapp.pages.DataTablesPage;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day16_ExcelTest {

    DataTablesPage dataTablesPage;
    ExcelUtils excelUtils;//to access ExcelUtils objects and methods
    List<Map<String,String>> dataList;//this container will hold the excel data



    @Test
    public void userCreationTest(){
//        path of the excel
        String pathOfDataSheet = "./resources/data_sheet.xlsx";
//        instantiating excel util object to have access to the excel utils methods
        excelUtils = new ExcelUtils(pathOfDataSheet,"user_data");
//        get data from excel using reusable method
        dataList = excelUtils.getDataList();
//        System.out.println(dataList);




//        When user go to  https://editor.datatables.net/
        Driver.getDriver().get("https://editor.datatables.net/");
//        Click on the new button
        DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage.newButton.click();
//        When user enters all fields
        dataTablesPage.firstName.sendKeys();
        WaitUtils.waitFor(1);
        dataTablesPage.lastName.sendKeys();
        WaitUtils.waitFor(1);
        dataTablesPage.position.sendKeys();
        WaitUtils.waitFor(1);
        dataTablesPage.office.sendKeys();
        WaitUtils.waitFor(1);
        dataTablesPage.extension.sendKeys();
        WaitUtils.waitFor(1);
        dataTablesPage.start_date.sendKeys();
        WaitUtils.waitFor(1);
        dataTablesPage.salary.sendKeys();
        WaitUtils.waitFor(1);
//        When clicks create button
        dataTablesPage.createButton.click();
        WaitUtils.waitFor(1);
//        And search for the first name
        dataTablesPage.searchBox.sendKeys();
        WaitUtils.waitFor(1);
//        Then verify the name fields contains first name
    }



}
