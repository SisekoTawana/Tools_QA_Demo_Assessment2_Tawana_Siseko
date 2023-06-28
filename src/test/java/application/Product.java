package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product {
    WebDriver driver = Tests.driver;
    Home home;
    @FindBy(linkText = "Radiant Tee")
    WebElement radiantTee;
    @FindBy(linkText = "Breathe-Easy Tank")
    WebElement breatheEasyTank;
    @FindBy(linkText = "Argus All-Weather Tank")
    WebElement argusAllWeatherTank;
    @FindBy(className = "Hero Hoodie")
    WebElement heroHoodie;

    public void addRadiantTee() {

    }

    public void addBreatheEasyTank() {
        breatheEasyTank.click();
    }

    public void addArgusAllWeatherTank() {
        argusAllWeatherTank.click();
    }
    public void addHeroHoodie() {
        heroHoodie.click();
    }
}
