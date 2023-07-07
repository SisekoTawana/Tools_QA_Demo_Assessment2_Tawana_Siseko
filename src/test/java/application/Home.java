package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ActionHelper;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Home {
    private static WebDriver driver;
    static Actions actions = new Actions(Tests.driver);

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.findElement(logolink()).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/");
    }
    public void setEmailAddress(String emailData) {
       WebElement EmailElement = driver.findElement(emailAddress());
       EmailElement.clear();
       driver.findElement(emailAddress()).sendKeys(emailData/*"siseko@digilink.africa"*/);
    }
    public void setPassword(String passwordData) {
        WebElement passwordElement = driver.findElement(password());
        passwordElement.clear();
        driver.findElement(password()).sendKeys(passwordData/*"SetoT_2023"*/);
    }
    public void navigateToTeesAndClick() throws InterruptedException {
        //Hover on men
        WebElement men = Tests.driver.findElement(By.xpath("(//a[@id='ui-id-5'])[1]"));
        actions.moveToElement(men).perform();
        ActionHelper.talkScreenshot(driver);
        Thread.sleep(2000);
        //Hover on top
        WebElement tops = Tests.driver.findElement(By.xpath("(//a[@id='ui-id-17'])[1]"));
        actions.moveToElement(tops).build().perform();
        ActionHelper.talkScreenshot(driver);
        Thread.sleep(2000);
        Tests.driver.findElement(By.xpath("(//a[@id='ui-id-21'])[1]")).click();
    }
    public void clickSignInLink() {
        driver.findElement(signinLink()).click();
    }
    public Home clickSignIn() {
        driver.findElement(signin()).click();
        ActionHelper.talkScreenshot(driver);
        return new Home(driver);
    }
    public String verifyLoginPass() {
        return driver.findElement(loginPassMessage()).getText();
        /*Assert.assertEquals(driver., "https://magento.softwaretestingboard.com/");*/
    }
    private By logolink(){
        return By.className("logo");
    }
    private By signinLink() {
        return By.linkText("Sign In");
    }
    private By emailAddress(){
        return By.id("email");
    }
    private By password(){
        return By.id("pass");
    }

    private By signin() {
        return By.id("send2");
    }

    private By loginPassMessage() {
        return By.className("greet welcome");
    }

    private By toTees() {
        return By.xpath("//*[@id=\"ui-id-21\"]/span");
    }
}
