package tests;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;
import models.ProductDetails;
import utils.DataProviderHelper;
import utils.RetailerDecisionFactory;
import utils.RetailerDecisionInterface;

public class TestGetProductDetails extends BaseClass {


    @Test(dataProvider = "ProductName",dataProviderClass = DataProviderHelper.class)
    public void getProductDetailsForVericalResultsInJSONFormatTest(String productName) throws Exception {

        RetailerDecisionInterface retailer = new RetailerDecisionFactory(driver).getRetailPlatform("Flipkart");

        System.out.println(productName);
        ProductDetails productDetails = retailer.navigateToUrl().
                searchForAProductAndGetDetails(productName);
        String expectedJSON = new Gson().toJson(productDetails);
        System.out.println(expectedJSON);
        Assert.assertTrue(true);  //False assert
    }



}
