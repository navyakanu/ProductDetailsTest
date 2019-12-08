package utils;

import models.ProductDetails;

public interface RetailerDecisionInterface {

    public RetailerDecisionInterface navigateToUrl();

    public ProductDetails searchForAProductAndGetDetails(String productName);



}
