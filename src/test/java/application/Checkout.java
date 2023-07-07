package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Checkout {
    private WebDriver driver;
    public Checkout(WebDriver driver){
        this.driver = driver;
    }
    public void clickProceedToCheckout(){
        driver.findElement(proceedToCheckout()).click();
    };
    public void setFirstName(String firstName) {
        WebElement EmailElement = driver.findElement(fName());
        EmailElement.clear();
        driver.findElement(fName()).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        WebElement EmailElement = driver.findElement(lName());
        EmailElement.clear();
        driver.findElement(lName()).sendKeys(lastName);
    }
    public void setCompany(String company) {
        WebElement EmailElement = driver.findElement(companyName());
        EmailElement.clear();
        driver.findElement(companyName()).sendKeys(company);
    }
    public void setAddress(String address) {
        WebElement EmailElement = driver.findElement(addresses());
        EmailElement.clear();
        driver.findElement(addresses()).sendKeys(address);
    }
    public void setCity(String city) {
        WebElement EmailElement = driver.findElement(cities());
        EmailElement.clear();
        driver.findElement(cities()).sendKeys(city);
    }
    public void clickProvince(String province) {
        driver.findElement(provinces()).click();
    }
    public void setCode(String code) {
        WebElement EmailElement = driver.findElement(postalCode());
        EmailElement.clear();
        driver.findElement(postalCode()).sendKeys(code);
    }
    public void clickCountry(String country) {
        driver.findElement(country()).click();
    }
    public void setPhone(String phone) {
        WebElement EmailElement = driver.findElement(phone());
        EmailElement.clear();
        driver.findElement(phone()).sendKeys(phone);
    }
    public void clickShippingMethod() {
        driver.findElement(shippingMethod()).click();
    }
    public void clickNextButton() {
        driver.findElement(nextButton()).click();
        WebElement message = driver.findElement(confimation());
        String expectedMessage = "Check / Money order";
        String actualMessage = message.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    private By proceedToCheckout(){
        return By.className("action primary checkout");}
    private By fName() {
        return By.xpath("(//input[@id='THYDLG2'])[1]");
    }
    private By lName() {
        return By.xpath("(//input[@id='X4UFBS8'])[1]");
    }
    private By companyName() {
        return By.xpath("(//input[@id='H5G1T49'])[1]");
    }
    private By addresses() {
        return By.xpath("(//input[@id='DS82O6Y'])[1]");
    }
    private By cities() {
        return By.xpath("(//input[@id='HXRF6K0'])[1]");
    }
    private By provinces() {
        return By.xpath("(//input[@id='FX8AX9U'])[1]");
    }
    private By postalCode() {
        return By.xpath("(//input[@id='YWK7YQ0'])[1]");
    }
    private By country() {
        return By.xpath("(//select[@id='O9E65E7'])[1]");
    }
    private By phone() {
        return By.xpath("(//input[@id='WRXWU74'])[1]");
    }
    private By shippingMethod() {
        return By.xpath("(//input[@id='WRXWU74'])[1]");
    }
    private By nextButton() {
        return By.xpath("(//button[@class='button action continue primary'])[1]");
    }
    private By confimation(){
        return By.xpath("(//span[normalize-space()='Check / Money order'])[1]");
    }
}
