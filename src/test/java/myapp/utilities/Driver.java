package myapp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;
    public static WebDriver getDriver(){

        if (driver==null) {//if driver is not in use(driver==null), there create a new driver. otherwise just return the  same driver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.manage().window().maximize();
        }


        return driver;
    }
    //close driver
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }


}
