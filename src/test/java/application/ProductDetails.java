package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails {
    private WebDriver driver;
    /*@FindBy(id = "option-label-size-143-item-168")
    WebElement heroHoodieSize;*/
    private By heroHoodieSize = By.id("option-label-size-143-item-168");
  /*  @FindBy(id = "option-label-color-93-item-53")
    WebElement heroHoodieColour;*/
    private By heroHoodieColour = By.id("option-label-color-93-item-53");
    /*@FindBy(id = "option-label-size-143-item-167")
    WebElement mikoPulloverHoodieSize;*/
    private By mikoPulloverHoodieSize = By.id("option-label-size-143-item-167");
    /*@FindBy(id = "option-label-color-93-item-56")
    WebElement mikoPulloverHoodieColour;*/
    private By mikoPulloverHoodieColour = By.id("option-label-color-93-item-56");

    public ProductDetails(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHeroHoodieSize(){
        driver.findElement(heroHoodieSize).click();
    }
    public void clickHeroHoodieColor(){
        driver.findElement(heroHoodieColour).click();
    }
    public void clickMikoPulloverHoodieSize(){
        driver.findElement(mikoPulloverHoodieSize).click();
    }
    public void clickMikoPulloverHoodieColor() {
        driver.findElement(mikoPulloverHoodieColour).click();
    }
}
