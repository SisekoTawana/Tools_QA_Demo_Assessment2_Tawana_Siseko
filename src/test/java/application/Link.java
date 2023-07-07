package application;

import org.openqa.selenium.WebDriver;
import utilities.ActionHelper;

public class Link {
    private WebDriver driver;
    public Link(WebDriver driver) {
        this.driver = driver;
    }
    public void goTo(){
        driver.get("https://magento.softwaretestingboard.com/");
        ActionHelper.talkScreenshot(driver);
    }
}
