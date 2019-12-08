package Flows;

import models.ProductDetails;
import org.openqa.selenium.WebDriver;
import pages.HomePageAmazon;
import pages.HomePageFlipkart;
import utils.Helpers;
import utils.RetailerDecisionInterface;

public class FlipkartFlow extends Helpers implements RetailerDecisionInterface {

    private String baseURL = "https://www.flipkart.com/";

    public FlipkartFlow(WebDriver driver) {
        super(driver);
    }


    public FlipkartFlow navigateToUrl() {
        try {
            driver.get(baseURL);
        } catch (Exception e) {
            System.out.println("URL is incorrect can not proceed further with the test");
        }
        return this;
    }



    public ProductDetails searchForAProductAndGetDetails(String productName) {
        HomePageFlipkart homePage = new HomePageFlipkart(driver);
        return  homePage.closeLoginPopUp().searchForAProduct(productName).clickAndNavigateToProductDetails(productName).getProductDetails();
    }



}
