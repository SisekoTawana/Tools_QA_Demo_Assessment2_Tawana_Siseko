package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails {
    WebDriver driver = Tests.driver;
    @FindBy(id = "option-label-size-143-item-168")
    WebElement size;
    @FindBy(id = "option-label-color-93-item-53")
    WebElement colour;

    public void clickSize(){
        size.click();
    }
    public void clickColor(){
        colour.click();
    }
}
