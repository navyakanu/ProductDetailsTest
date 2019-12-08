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

import java.util.Iterator;
import java.util.List;

public class HomePageFlipkart extends Helpers {

    @FindBy(className = "_29YdH8")
    private WebElement loginPopUp;

    @FindAll({
            @FindBy(className = "_1UoZlX"),
            @FindBy(className = "_2cLu-l")
    }
    )
    private List<WebElement> productResult;


    @FindBy(className = "vh79eN")
    public WebElement searchButton;

    @FindBy(className = "LM6RPg")
    public WebElement searchBar;


    @FindBy(className = "hGSR34")
    public WebElement productRating;

    @FindBy(className = "_35KyD6")
    public WebElement webproductName;

    @FindBy(className = "_3qQ9m1")
    public WebElement productPrice;

    @FindBy(className = "_2-riNZ")
    public WebElement productDescription;

//TODO: Lot of repetition of the method, only uncommon methods should be in the flow file and rest should carry on in one page file alone


    public HomePageFlipkart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePageFlipkart closeLoginPopUp() {
        try {
            loginPopUp.click();
        } catch (Exception e) {

        }
        return this;
    }

    public HomePageFlipkart searchForAProduct(String showName) {
        waitForElement(searchBar);
        searchBar.click();
        searchBar.sendKeys(showName);
        searchButton.click();
        searchButton.click();
        return this;
    }

    public HomePageFlipkart clickAndNavigateToProductDetails(String productName) {
        Boolean flag = false;
        for (Iterator iterator = productResult.iterator(); iterator.hasNext(); ) {
            WebElement product = (WebElement) iterator.next();

            if ((product.getText().toUpperCase()).contains(productName.toUpperCase())) {
                driver.findElement(By.linkText(product.getText())).click();
                switchWindowHandle(driver);
                flag = true;
                break;
            }
        }
        if (flag == true) {
            return this;
        } else {
            //throw new Exception("Could not find the results for the product "+ productName);
        }
        return this;
    }

    public ProductDetails getProductDetails() {
        String productRatingValue = getValueOfProductIfExists(productRating);
        return new ProductDetails(webproductName.getText(),
                productPrice.getText(),
                "No delivery time mentioned",
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
            productRating = "No " + element + " found";
        }
        return productRating;
    }


}
