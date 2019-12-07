package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    //Need to take this from properties file
    private String baseURL = "http://amazon.in/";

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try{
            driver.get(baseURL);
        }
        catch (Exception e){
            System.out.println("URL is incorrect can not proceed further with the test");
        }
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }

    }
}
