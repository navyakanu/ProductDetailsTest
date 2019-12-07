package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.ProductDetailsPageObjects;
import utils.Helpers;
import models.ProductDetails;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsPage extends Helpers {

    private ProductDetailsPageObjects productDetailsPageObjects;

    public ProductDetailsPage(WebDriver driver) throws Exception {
        super(driver);
        List<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        productDetailsPageObjects = new ProductDetailsPageObjects();
        PageFactory.initElements(driver, productDetailsPageObjects);
        try{
            waitForElement(productDetailsPageObjects.productDetails);
        }
        catch (Exception e ){
            System.out.print("Product not found");
        }
        return;
    }

    public ProductDetails getProductDetails(){

        return new ProductDetails(productDetailsPageObjects.productName.getText(),
                                    productDetailsPageObjects.productPrice.getText(),
                                    productDetailsPageObjects.productDevileryTime.getText(),
                productDetailsPageObjects.productRating.getAttribute("title"),
                productDetailsPageObjects.productDescription.getText(),
                driver.getCurrentUrl());




    }






}