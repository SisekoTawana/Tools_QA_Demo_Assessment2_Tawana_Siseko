package application;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProducts {
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[4]/div/div[2]/a[2]")
    WebElement addToCompareMultiView;
    @FindBy(className = "action tocompare")
    WebElement addToCompare;
    @FindBy(linkText = "comparison list")
    WebElement comparisonList;
    @FindBy(xpath = "//*[@id=\"product-comparison\"]/thead/tr/td[1]/a")
    WebElement removeArgusAllWeatherTank;
    public void clickAddToCompareMultiView(){
        addToCompareMultiView.click();
    }
    public void clickAddToCompare(){
        addToCompare.click();
    }
    public void clickComparisonList(){
        comparisonList.click();
    }

    public void removeToCompareList() {
        removeArgusAllWeatherTank.click();
    }
}
