package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePageObjects {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(className = "nav-input")
    public WebElement searchButton;

    @FindBys( {
            @FindBy (className = "s-search-results"),
            @FindBy(css = "h2")
    } )
    public List<WebElement> productResult;

}
