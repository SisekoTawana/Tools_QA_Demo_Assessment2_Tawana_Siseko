package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails {
    WebDriver driver = Tests.driver;
    @FindBy(id = "option-label-size-143-item-168")
    WebElement heroHoodieSize;
    @FindBy(id = "option-label-color-93-item-53")
    WebElement heroHoodieColour;
    @FindBy(id = "option-label-size-143-item-167")
    WebElement mikoPulloverHoodieSize;
    @FindBy(id = "option-label-color-93-item-56")
    WebElement mikoPulloverHoodieColour;

    public void clickHeroHoodieSize(){
        heroHoodieSize.click();
    }
    public void clickHeroHoodieColor(){
        heroHoodieColour.click();
    }
    public void clickMikoPulloverHoodieSize(){
        mikoPulloverHoodieSize.click();
    }
    public void clickMikoPulloverHoodieColor() {
        mikoPulloverHoodieColour.click();
    }
}
