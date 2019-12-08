package pages;

import models.ProductDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;
import utils.RetailerDecisionInterface;

import java.util.Iterator;
import java.util.List;

public class HomePageAmazon extends Helpers {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(className = "nav-input")
    public WebElement searchButton;

    @FindBys( {
            @FindBy (className = "s-search-results"),
            @FindBy(css = "h2")
    } )
    public List<WebElement> productResult;

    @FindBy(id = "feature-bullets")
    public WebElement productDetails;

    @FindBy(id = "productTitle")
    public WebElement productName;

    @FindAll({
            @FindBy(id = "priceblock_ourprice"),
            @FindBy(id = "priceblock_saleprice")
    }
    )

    public WebElement productPrice;

    @FindBy(id = "ddmDeliveryMessage")
    public WebElement productDevileryTime;


    @FindBy(id = "feature-bullets")
    public WebElement productDescription;


    @FindBy(id = "acrPopover")
    public WebElement productRating;

    public RetailerDecisionInterface retailer;

    public HomePageAmazon(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitForElement(searchBar);
    }

    public HomePageAmazon searchForAProduct(String showName)  {
        waitForElement(searchBar);
        searchBar.click();
        searchBar.sendKeys(showName);
        searchButton.click();
        searchButton.click();
        return this;
    }


    public HomePageAmazon clickAndNavigateToProductDetails(String productName)  {
        Boolean flag = false;
        for (Iterator iterator = productResult.iterator(); iterator.hasNext(); ) {
            WebElement product = (WebElement) iterator.next();
            if ((product.getText().toUpperCase()).contains(productName.toUpperCase())) {
                driver.findElement(By.linkText(product.getText())).click();
                switchWindowHandle(driver);
                flag=true;
                break;
            }
        }
        if(flag == true) {
            return this;
        }
        else {
            //throw new Exception("Could not find the results for the product "+ productName);
        }
        return this;
    }

    public ProductDetails getProductDetails() {
        String productRatingValue = getValueOfProductIfExists(productRating);
        return new ProductDetails(productName.getText(),
                productPrice.getText(),
                productDevileryTime.getText(),
                productRatingValue,
                productDescription.getText(),
                driver.getCurrentUrl());


    }

    private String getValueOfProductIfExists(WebElement element) {
        String productRating;
        try {
            waitForElement(element);
            productRating = element.getAttribute("title");
        } catch (Exception e) {
            productRating = "No " +  element + " found";
        }
        return productRating;
    }



}
