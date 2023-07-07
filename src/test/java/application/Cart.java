package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.ActionHelper;

public class Cart {
    private WebDriver driver = Tests.driver;
    public Cart (WebDriver driver){
        this.driver =driver;}

    public void addProductToCart() {
        driver.findElement(addToCart()).click();
    }
    public void viewShoppingCart(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(shoppingCart()).click();
    }
    public void add3StarProductToCart() {
        WebElement AddedMessage = driver.findElement(errorMessage());
        String expectedMessage = "This is a required field.";
        String actualMessage = AddedMessage.getText();
        ActionHelper.talkScreenshot(driver);
        driver.findElement(add3StarToCart()).click();
        Assert.assertNotEquals(actualMessage, expectedMessage);
    }
    private By addToCart() {
        return By.cssSelector("#product-addtocart-button");
    }
    private By shoppingCart() {
        return By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)'] a");
    }
    private By add3StarToCart() {
        return By.xpath("(//button[@id='product-addtocart-button'])[1]");
    }
    private By errorMessage(){
        return By.xpath("(//div[@id='super_attribute[93]-error'])[1]");
    }
}
