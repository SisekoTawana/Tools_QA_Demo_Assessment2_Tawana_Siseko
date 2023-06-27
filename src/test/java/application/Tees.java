package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tees {
    WebDriver driver = Tests.driver;
    @FindBy(className = "logo")
    WebElement logolink;
    @FindBy(linkText = "Radiant Tee")
    WebElement radiantTee;
    @FindBy(linkText = "Breathe-Easy Tank")
    WebElement breatheEasyTank;
    @FindBy(linkText = "Breathe-Easy Tank")
    WebElement argusAllWeatherTank;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[2]/span")
    WebElement addToCompare;
    @FindBy(linkText = "comparison list")
    WebElement comparisonList;

    public void addRadiantTeeWhileNotLoggedIn(String url) {
        driver.get(url);
        /*logolink.click();*/
        radiantTee.click();
        addToCompare.click();
        comparisonList.click();
    }

    public void addBreatheEasyTankWhileNotLoggedIn(String url) {
        logolink.click();
        breatheEasyTank.click();
        addToCompare.click();
        comparisonList.click();
    }

    public void removeArgusAllWeatherTank(String url) {
        logolink.click();
        breatheEasyTank.click();
        addToCompare.click();
        comparisonList.click();
    }
}
