package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {
    WebDriver driver = Tests.driver;
    @FindBy(id = "product-addtocart-button")
    WebElement addToCart;
        @FindBy(linkText = "shopping cart")
        WebElement shoppingCart;
            @FindBy(className = "action tocart primary")
            WebElement add3StarToCart;

    public void addProductToCart() {
        addToCart.click();
    }
        public void viewShoppingCart(){
            shoppingCart.click();
        }
            public void add3StarProductToCart() {
                add3StarToCart.click();
            }
}
