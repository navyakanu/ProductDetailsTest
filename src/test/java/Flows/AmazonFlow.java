package Flows;

import models.ProductDetails;
import org.openqa.selenium.WebDriver;
import pages.HomePageAmazon;
import utils.Helpers;
import utils.RetailerDecisionInterface;

public class AmazonFlow extends Helpers implements RetailerDecisionInterface {

    private String baseURL = "http://amazon.in/";
    public AmazonFlow(WebDriver driver) {
        super(driver);
    }

    @Override
    public AmazonFlow navigateToUrl() {
        try {
            driver.get(baseURL);
        } catch (Exception e) {
            System.out.println("URL is incorrect can not proceed further with the test");
        }
        return this;
    }

    @Override
    public ProductDetails searchForAProductAndGetDetails(String productName) {
        HomePageAmazon homePage = new HomePageAmazon(driver);
        return  homePage.searchForAProduct(productName).clickAndNavigateToProductDetails(productName).getProductDetails();

    }

}
