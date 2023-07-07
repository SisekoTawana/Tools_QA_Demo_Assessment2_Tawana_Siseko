package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ActionHelper;

public class CompareProducts {
    private WebDriver driver;
    public CompareProducts(WebDriver driver){
        this.driver = driver;
    }
    public void clickOkButton(){
        driver.findElement(okButton()).click();
    }
    public void clickAddToCompare(){
        driver.findElement(addToCompare()).click();
        ActionHelper.talkScreenshot(driver);
    }
    public void clickComparisonList(){
        driver.findElement(comparisonList()).click();
        ActionHelper.talkScreenshot(driver);
    }
    public void removeToCompareList() {
        driver.findElement(removeArgusAllWeatherTank()).click();
    }
    private By okButton(){
        return By.cssSelector("button[class='action-primary action-accept'] span");
    }
    private By addToCompare() {
        return By.cssSelector("a[class='action tocompare'] span");
    }
    private By comparisonList() {
        return By.xpath("(//a[normalize-space()='comparison list'])[1]");
    }
    private By removeArgusAllWeatherTank(){
       return By.xpath("//*[@id=\"product-comparison\"]/thead/tr/td[1]/a");
    }
}

