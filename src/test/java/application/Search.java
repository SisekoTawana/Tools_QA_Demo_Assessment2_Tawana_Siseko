/*
package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search {
    private WebDriver driver;

    public Search(WebDriver driver){
        this.driver = driver;
    private By searchField(){
        return By.xpath("(//input[@id='search'])[1]");
    }
    private By searchIcon(){
        return By.xpath("(//button[@title='Search'])[1]");
    }
    public void searchProduct() {
        WebElement searchFieldElement = driver.findElement(searchField());
        searchFieldElement.clear();
        searchFieldElement.sendKeys();
        driver.findElement(searchIcon()).click();
    }
}
*/
