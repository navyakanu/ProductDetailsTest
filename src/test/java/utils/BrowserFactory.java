package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    public static WebDriver getBrowser(String browserName){
        WebDriver driver = null;
        switch (browserName){
            case "chrome":
                System.out.println("Chrome Browser");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Invalid browser Name");
                break;
        }
        return driver;
    }
}
