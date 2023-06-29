package application;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.ActionHelper;

public class Home {
WebDriver driver = Tests.driver;
ExtentTest test = Tests.test;
    @FindBy(className = "logo")
    WebElement logolink;
    @FindBy(linkText = "Sign In")
    WebElement signinLink;
    @FindBy(id = "email")
    WebElement emailAddress;
    @FindBy(id = "pass")
    WebElement password;
    @FindBy(id = "send2")
    WebElement signin;
    @FindBy(className = "greet welcome")
    WebElement loginPassMessega;
    @FindBy(id = "ui-id-21")
    WebElement toTees;
    public void navigateToHomePage(String url){
        test.log(Status.INFO, "navigating to home Page");
        driver.get(url);

        logolink.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/");
        ActionHelper.talkScreenshot(driver);
    }
    public void captureCredentialsAndSubmit() {
        test.log(Status.INFO, "Capturing signing in details and submitting");
        String email_address = "Sese";
        String password = "Tata";
        this.emailAddress.sendKeys(email_address);
        this.password.sendKeys(password);
        ActionHelper.talkScreenshot(driver);
        signin.click();
    }
    public void navigateToTeesAndClick() {
        toTees.click();
    }
    public void clickSignInLink() {
        signinLink.click();
    }

    public void verifyLoginPass() {
        test.log(Status.INFO, "Verifying if sign in passes");
        Assert.assertTrue(loginPassMessega.isDisplayed());
        ActionHelper.talkScreenshot(driver);
    }
}
