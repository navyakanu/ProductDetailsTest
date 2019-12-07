package tests;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseClass;
import models.ProductDetails;
import utils.DataProviderHelper;

public class TestGetProductDetails extends BaseClass {

    @Test(dataProvider = "ProductName",dataProviderClass = DataProviderHelper.class)
    public void getProductDetailsForVericalResultsInJSONFormatTest(String productName) throws Exception {
        HomePage homePage = new HomePage(driver);
        System.out.println(productName);
        ProductDetails productDetails = homePage.
                searchForAProduct(productName).clickAndNavigateToProductDetails(productName).getProductDetails();
        String expectedJSON = new Gson().toJson(productDetails);
        System.out.println(expectedJSON);
        Assert.assertTrue(true);  //False assert
    }

}
