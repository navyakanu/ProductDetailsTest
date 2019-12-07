package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ProductDetailsPageObjects {

    @FindBy(id = "feature-bullets")
    public WebElement productDetails;

    @FindBy(id = "productTitle")
    public WebElement productName;

    @FindAll({
            @FindBy(id = "priceblock_ourprice"),
            @FindBy(id = "priceblock_saleprice")
    }
    )

    public WebElement productPrice;

    @FindBy(id = "ddmDeliveryMessage")
    public WebElement productDevileryTime;


    @FindBy(id = "feature-bullets")
    public WebElement productDescription;

    @FindBy(id = "acrPopover")
    public WebElement productRating;


}
