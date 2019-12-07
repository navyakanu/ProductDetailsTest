package models;

public class ProductDetails {

    String productName;
    String productPrice;
    String productDescription;
    String productRating;
    String productDevileryTime;
    String productURL;

    public ProductDetails(String productName,
                          String productPrice,
                          String productDevileryTime,
                          String productRating,
                          String productDescription,
                          String productURL) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDevileryTime = productDevileryTime;
        this.productRating = productRating;
        this.productDescription = productDescription;
        this.productURL = productURL;
    }


}
