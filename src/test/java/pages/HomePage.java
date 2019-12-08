package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePageObjects;
import utils.Helpers;

import java.util.Iterator;
import java.util.List;

public class HomePage extends Helpers {

    private HomePageObjects homePageObjects;

    public HomePage(WebDriver driver) {
        super(driver);
        homePageObjects = new HomePageObjects();
        PageFactory.initElements(driver, homePageObjects);
        waitForElement(homePageObjects.searchBar);
    }

    public HomePage searchForAProduct(String showName) throws Exception {
        homePageObjects.searchBar.click();
        homePageObjects.searchBar.sendKeys(showName);
        homePageObjects.searchButton.click();
        homePageObjects.searchButton.click();
        return this;
    }


    public ProductDetailsPage clickAndNavigateToProductDetails(String productName) throws Exception {
        Boolean flag = false;
        for (Iterator iterator = homePageObjects.productResult.iterator(); iterator.hasNext(); ) {
            WebElement product = (WebElement) iterator.next();
            if ((product.getText().toUpperCase()).contains(productName.toUpperCase())) {
                driver.findElement(By.linkText(product.getText())).click();
                flag=true;
                break;
            }
        }
        if(flag == true) {
            return new ProductDetailsPage(driver);
        }
        else {
            throw new Exception("Could not find the results for the product "+ productName);
        }
    }

}
