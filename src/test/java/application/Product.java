package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ActionHelper;

import static application.Home.actions;

public class Product {
    private WebDriver driver;

    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public void addRadiantTee() throws InterruptedException {
        WebElement hover = driver.findElement(By.xpath("(//img[@alt='Radiant Tee'])[1]"));
        actions.moveToElement(hover).build().perform();
        ActionHelper.talkScreenshot(driver);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@title='Add to Compare'])[1]")).click();
        ActionHelper.talkScreenshot(driver);
    }

    public void addBreatheEasyTank() {
        driver.findElement(breatheEasyTank()).click();
        ActionHelper.talkScreenshot(driver);
    }

    public void addArgusAllWeatherTank() {
        driver.findElement(argusAllWeatherTank()).click();
    }
    public void addHeroHoodie() {
        driver.findElement(heroHoodie()).click();
    }
    public void clickThreeStarProduct(){
        ActionHelper.talkScreenshot(driver);
        driver.findElement(threeStarProduct()).click();
    }

    public void clickMikoPulloverHoodie() {
        driver.findElement(mikoPulloverHoodie()).click();
    }
    private By radiantTee(){
        return By.linkText("Radiant Tee");
    }
    private By breatheEasyTank() {
        return By.linkText("Breathe-Easy Tank");
    }
    private By argusAllWeatherTank() {
        return By.linkText("Argus All-Weather Tank");
    }
    private By threeStarProduct(){ return By.xpath("(//img[contains(@alt,'HeatTec® Tee')])[1]");}
    private By heroHoodie() {
        return By.linkText("Hero Hoodie");
    }
    private By mikoPulloverHoodie() {
        return By.linkText("Miko Pullover Hoodie");
    }
}
