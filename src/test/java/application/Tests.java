package application;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tests {
    static WebDriver driver;
    ExtentSparkReporter htmlReport;
    ExtentReports extent;
    ExtentTest test;
    Home home;
    Product products;
    CompareProducts compareProducts;
    ProductDetails productDetails;
    Cart cart;

    public Tests(){
        home = new Home();
        products = new Product();
        cart = new Cart();
        compareProducts = new CompareProducts();
        productDetails = new ProductDetails();
    }
    @Parameters("browser")
    @BeforeTest
    //setting up WebDriver & extentReports
    public void setUp(String browser){
        if(browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }  else{
            throw new RuntimeException("Browser name '"+ browser + "'could not be found. Check spelling");
        }
        driver.manage().window().maximize();

        String file = System.getProperty("user.dir")
                + "src/test/java/reporting/LumaTestReport_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HH.mm.ss")) + ".html";
        htmlReport = new ExtentSparkReporter(file);
        extent = new ExtentReports();
        //ExtentReports - configuration items to change the look and feel
        htmlReport.config().setDocumentTitle("Demo shop Automation Report 2");
        htmlReport.config().setReportName("Test Report");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setTimeStampFormat("EEEE, MMM dd, yyyy, hh:mm a '('zzz')'");
    }
    @Test
    @Parameters("url")
    //valid login test
    public void validLogin(String url){
        test.createNode("Valid login test", "TC-001");
        home.navigateToHomePage(url);
        home.captureCredentialsAndSubmit();
        home.verifyLoginFails();

    }
    @Test
    //add Radiant Tee
    public void addRadiantTee(String url){
        home.navigateToHomePage(url);
        compareProducts.clickAddToCompareMultiView();
        compareProducts.clickComparisonList();
    }
    @Test
    //add Breathe Easy Tank
    public void addBreatheEasyTank(String url) {
        home.navigateToHomePage(url);
        products.addBreatheEasyTank();
        compareProducts.clickAddToCompare();
        compareProducts.clickComparisonList();
    }
    @Test
    public void addAndRemoveArgusAllWeatherTank(String url) {
        home.navigateToHomePage(url);
        products.addArgusAllWeatherTank();
        compareProducts.clickAddToCompare();
        compareProducts.clickComparisonList();
        compareProducts.removeToCompareList();
    }
    @Test
    //add product to cart
    public void addProductToCart(String url){
        home.navigateToHomePage(url);
        products.addHeroHoodie();
        productDetails.clickSize();
        productDetails.clickColor();
        cart.addProductToCart();
        cart.viewShoppingCart();
    }
    @Test
    //add 3 star product to cart
    public void add3StarProductToCartWhileLoggedIn(String url){
        home.navigateToHomePage(url);
        home.clickSignInLink();
        home.captureCredentialsAndSubmit();
        home.clickSignInButton();
        home.navigateToHomePage(url);
        home.navigateToTeesAndClick();
        cart.add3StarProductToCart();
    }
    @Test
    //add Miko Pullover Hoodie
    public void addMikoPulloverHoodie(String url){
         home.navigateToHomePage(url);
    }
    @AfterTest
    //tearDown
    public void tearDown(){
        driver.quit();
        extent.flush();
    }
}
