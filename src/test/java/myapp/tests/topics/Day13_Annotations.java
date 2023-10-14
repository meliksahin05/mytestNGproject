package myapp.tests.topics;

import org.testng.annotations.*;

public class Day13_Annotations {



    /*
    @Test : is used to create test cases - same as junit
    @Before and @After annotations : there are 5 before and 5 after annotation
    Hierarchy : suite > test > group > class > method
     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("before groups");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @BeforeMethod
    public void beforeMethods(){
        System.out.println("before methods");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("after groups");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }
    @AfterSuite
    public void afterMethod(){
        System.out.println("after method");
    }


    @Test
    public void test1(){
        System.out.println("test case 1");
    }
    @Test
    public void test2(){
        System.out.println("test case 2");
    }
    @Test
    public void test3(){
        System.out.println("test case 3");
    }
    @Test
    public void test4(){
        System.out.println("test case 4");
    }
    @Test
    public void test5(){
        System.out.println("test case 5");
    }
}
