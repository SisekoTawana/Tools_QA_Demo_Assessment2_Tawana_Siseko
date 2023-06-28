package application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
WebDriver driver = Tests.driver;
    @FindBy(className = "logo")
    WebElement logolink;
    @FindBy(className = "logo")
    WebElement username;
    @FindBy(className = "logo")
    WebElement password;
    @FindBy(id = "ui-id-21")
    WebElement toTees;
    public void navigateToHomePage(String url){
        driver.get(url);
    }
    public void captureCredentialsAndSubmit() {
        String username = "Sese";
        String password = "Tata";
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }
    public void verifyLoginFails() {
    }
    public void navigateToTeesAndClick() {
        toTees.click();
    }
    public void clickSignInButton() {

    }
    public void clickSignInLink() {
    }
}
