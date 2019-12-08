package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    //Need to take this from properties file


    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }

    }
}
