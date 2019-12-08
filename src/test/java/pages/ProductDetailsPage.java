package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjects.ProductDetailsPageObjects;
import utils.Helpers;
import models.ProductDetails;


public class ProductDetailsPage extends Helpers {

    private ProductDetailsPageObjects productDetailsPageObjects;

    public ProductDetailsPage(WebDriver driver) throws Exception {
        super(driver);
        switchWindowHandle(driver);

        productDetailsPageObjects = new ProductDetailsPageObjects();
        PageFactory.initElements(driver, productDetailsPageObjects);
        try {
            waitForElement(productDetailsPageObjects.productDetails);
        } catch (Exception e) {
            System.out.print("Product not found");
            throw e;
        }
        return;
    }


    public ProductDetails getProductDetails() {
        String productRating = getValueOfProductIfExists(productDetailsPageObjects.productRating);
        return new ProductDetails(productDetailsPageObjects.productName.getText(),
                productDetailsPageObjects.productPrice.getText(),
                productDetailsPageObjects.productDevileryTime.getText(),
                productRating,
                productDetailsPageObjects.productDescription.getText(),
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
