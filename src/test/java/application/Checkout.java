package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout {
    WebDriver driver = Tests.driver;
    @FindBy(className = "action primary checkout")
    WebElement proceedToCheckout;
    @FindBy()
    WebElement email;
    @FindBy()
    WebElement fName;
    @FindBy()
    WebElement lName;
    @FindBy()
    WebElement company;
    @FindBy()
    WebElement address;
    @FindBy()
    WebElement city;
    @FindBy()
    WebElement province;
    @FindBy()
    WebElement postalCode;
    @FindBy()
    WebElement country;
    @FindBy()
    WebElement phone;
    @FindBy()
    WebElement shippingMethod;
    @FindBy()
    WebElement nextButton;

    public void clickProceedToCheckout(){
        proceedToCheckout.click();
    }

    public void setEmail() {
    }

    public void setFirstName() {
    }

    public void setLastName() {
    }

    public void setCompany() {
    }

    public void setAddress() {
    }

    public void setCity() {
    }

    public void clickProvince() {
    }

    public void setCode() {
    }

    public void clickCountry() {
    }

    public void setPhone() {
    }

    public void clickShippingMethod() {
    }

    public void clickNextButton() {
    }
}
