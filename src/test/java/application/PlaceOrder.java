package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrder {
    WebDriver driver = Tests.driver;
    @FindBy()
    WebElement placeOrder;

    public void clickPlaceOrder() {
    }
}
