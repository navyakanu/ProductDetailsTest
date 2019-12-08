package utils;

import Flows.AmazonFlow;
import Flows.FlipkartFlow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetailerDecisionFactory {

    private AmazonFlow amazonFlow;
    private FlipkartFlow flipkartFlow;
    public WebDriver driver;

    public RetailerDecisionFactory(WebDriver driver) {
        this.driver= driver;
    }

    public RetailerDecisionInterface getRetailPlatform(String platform) {
        if (platform == null) {
            return null;
        }
        if (platform.equalsIgnoreCase("Amazon")) {
            if (amazonFlow == null) {
                return amazonFlow = new AmazonFlow(driver);
            }
            return (RetailerDecisionInterface) amazonFlow;
        }

        if (platform.equalsIgnoreCase("Flipkart")) {
            if (flipkartFlow == null) {
                return flipkartFlow = new FlipkartFlow(driver);
            }
            return flipkartFlow;

        }
        return null;

    }

}


