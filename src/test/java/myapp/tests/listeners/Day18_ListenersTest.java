package myapp.tests.listeners;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({myapp.utilities.ListenerUtils.class})
// instead of above the annotation use <listeners> in the xml file
public class Day18_ListenersTest {

    @Test
    public void test1(){
        System.out.println("PASS");
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        System.out.println("FAILS");
        Assert.assertTrue(false);
    }
    @Test
    public void test3(){
        System.out.println("SKIPPED");
        throw new SkipException("Skipping test case on purpose");
    }
    @Test
    public void test4(){
        System.out.println("THROW ");
//        throw new NoSuchElementException("No Such Exception on Purpose");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.id("wrong-id"));//throw NoSuchElementException
    }
}

