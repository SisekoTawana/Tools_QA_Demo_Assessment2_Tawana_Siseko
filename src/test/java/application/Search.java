package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search {
    WebDriver driver = Tests.driver;
    @FindBy(id = "search")
    WebElement searchField;
    @FindBy(className = "action search")
    WebElement searchIcon;
    public void setSearchField(String product_Name) {
        WebElement searchFieldElement = driver.findElement((By) searchField);
        searchFieldElement.clear();
        searchFieldElement.sendKeys(product_Name);
        searchIcon.click();
    }
}
