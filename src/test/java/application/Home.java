package application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
WebDriver driver = Tests.driver;

    @FindBy(className = "logo")
    WebElement username;
    @FindBy(className = "logo")
    WebElement password;

    public void captureCredentialsAndSubmit() {
        String username = "Sese";
        String password = "Tata";
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void verifyLoginFails() {
    }
}
