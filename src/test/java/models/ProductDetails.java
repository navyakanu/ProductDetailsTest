package models;

public class ProductDetails {

    private String productName;
    private String productPrice;
    private String productDescription;
    private String productRating;
    private String productDevileryTime;
    private String productURL;

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
