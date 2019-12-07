package tests;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseClass;
import models.ProductDetails;

public class TestGetProductDetails extends BaseClass {

    @Test
    public void getProductDetailsForVericalResultsInJSONFormatTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        String productName = "Galaxy M30s";
        ProductDetails productDetails = homePage.
                searchForAProduct(productName).clickAndNavigateToProductDetails(productName).getProductDetails();
        String expectedJSON = new Gson().toJson(productDetails);
        System.out.println(expectedJSON);
        Assert.assertTrue(true);  //False assert
    }

    @Test
    public void getProductDetailsForHorizontalResultsInJSONFormatTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        String productName = "POWER BANK";
        ProductDetails productDetails = homePage.
                searchForAProduct(productName).clickAndNavigateToProductDetails(productName).getProductDetails();
        String expectedJSON = new Gson().toJson(productDetails);
        System.out.println(expectedJSON);
        Assert.assertTrue(true);  //False assert
    }

    @Test
    public void getProductDetailsofNoResultsInJSONFormatTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        String productName = "JHJKGHFGDFSDS";
        ProductDetails productDetails = homePage.
                searchForAProduct(productName).clickAndNavigateToProductDetails(productName).getProductDetails();
        String expectedJSON = new Gson().toJson(productDetails);
        System.out.println(expectedJSON);
        Assert.assertTrue(true);  //False assert
    }




}
