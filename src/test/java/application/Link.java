package application;

import org.openqa.selenium.WebDriver;

public class Link {
    private WebDriver driver;
    public Link(WebDriver driver) {
        this.driver = driver;
    }
    public void goTo(){
        driver.get("https://magento.softwaretestingboard.com/");
    }
}
