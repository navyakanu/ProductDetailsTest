package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Helpers {

    public WebDriver driver;

    WebDriverWait webDriverWait;

    public Helpers(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
    }

    public WebElement waitForElement(WebElement by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        return by;
    }

    public void switchWindowHandle(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String winHandle : windowHandles) {
            driver.switchTo().window(winHandle);
        }
    }

}


