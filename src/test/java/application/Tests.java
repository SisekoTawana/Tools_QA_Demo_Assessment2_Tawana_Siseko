package application;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ActionHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tests {
    public static WebDriver driver;
    ExtentSparkReporter htmlReport;
    ExtentReports extent;
    public static ExtentTest test;
    Home home;
    Product products;
    CompareProducts compareProducts;
    ProductDetails productDetails;
    Cart cart;
    Search search;
    Checkout checkout;
    PlaceOrder placeOrder;

   /* public Tests(){
        home = new Home();
        products = new Product();
        cart = new Cart();
        compareProducts = new CompareProducts();
        productDetails = new ProductDetails();
        search = new Search();
        checkout = new Checkout();
    }*/
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

        home = PageFactory.initElements(driver, Home.class);

        String fileSeparator = System.getProperty("file.separator");
        String file = System.getProperty("user.dir")
                + fileSeparator + "src"+ fileSeparator + "test" + fileSeparator + "java" + fileSeparator + "reporting" + fileSeparator + "LumaTestReport_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HH.mm.ss")) + ".html";
        htmlReport = new ExtentSparkReporter(file);
        extent = new ExtentReports();
        //ExtentReports - configuration items to change the look and feel
        htmlReport.config().setDocumentTitle("Demo shop Automation Report 2");
        htmlReport.config().setReportName("Test Report");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setTimeStampFormat("EEEE, MMM dd, yyyy, hh:mm a '('zzz')'");
    }
    @AfterMethod
    public void testResults(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS,result.getTestName());
        } else if (result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, result.getThrowable());
        } else {
            test.log(Status.SKIP, result.getTestName());
        }
    }
    @Test(priority = 4)
    @Parameters("url")
    //valid login test
    public void validLogin(String url){
        test = extent.createTest("TC-001:Valid login test", "");

        home.navigateToHomePage(url);
        home.captureCredentialsAndSubmit();
        home.verifyLoginPass();

    }
    @Test(priority = 1)
    //add Radiant Tee
    public void addRadiantTee(String url){
        test = extent.createTest("TC-001:Product Comparison", "Verify if a user not logged in can add product to compare multiple products view");

        home.navigateToHomePage(url);
        compareProducts.clickAddToCompareMultiView();
        compareProducts.clickComparisonList();
    }
    @Test(priority = 2)
    //add Breathe Easy Tank
    public void addBreatheEasyTank(String url) {
        test = extent.createTest("TC-002:Product Comparison", "Verify if a user not logged in can add product to compare products details view");

        home.navigateToHomePage(url);
        products.addBreatheEasyTank();
        compareProducts.clickAddToCompare();
        compareProducts.clickComparisonList();
        ActionHelper.talkScreenshot(driver);
    }
    @Test(priority = 3)
    public void addAndRemoveArgusAllWeatherTank(String url) {
        test = extent.createTest("TC-002:Product Comparison", "Verify if a user not logged in can add product to compare products details view");

        home.navigateToHomePage(url);
        products.addArgusAllWeatherTank();
        compareProducts.clickAddToCompare();
        compareProducts.clickComparisonList();
        ActionHelper.talkScreenshot(driver);
        compareProducts.removeToCompareList();
        ActionHelper.talkScreenshot(driver);
    }
    @Test
    //add product to cart
    public void addProductToCart(String url){
        test = extent.createTest("TC-002:Product Comparison", "Verify if a user not logged in can add product to compare products details view");

        home.navigateToHomePage(url);
        products.addHeroHoodie();
        productDetails.clickHeroHoodieSize();
        productDetails.clickHeroHoodieColor();
        cart.addProductToCart();
        cart.viewShoppingCart();
        ActionHelper.talkScreenshot(driver);
    }
    @Test
    //add 3 star product to cart
    public void add3StarProductToCartWhileLoggedIn(String url){
        test = extent.createTest("TC-002:Product Comparison", "Verify if a user not logged in can add product to compare products details view");

        home.navigateToHomePage(url);
        home.clickSignInLink();
        home.captureCredentialsAndSubmit();
        home.navigateToHomePage(url);
        home.navigateToTeesAndClick();
        ActionHelper.talkScreenshot(driver);
        cart.add3StarProductToCart();
        ActionHelper.talkScreenshot(driver);
    }
    @Test
    //add Miko Pullover Hoodie
    public void addMikoPulloverHoodie(String url){
        test = extent.createTest("TC-002:Product Comparison", "Verify if a user not logged in can add product to compare products details view");

        home.navigateToHomePage(url);
        String product_Name = excelData.getCellData();
        home.navigateToHomePage(url);
        search.setSearchField(product_Name);
        products.clickMikoPulloverHoodie();
        productDetails.clickMikoPulloverHoodieSize();
        productDetails.clickMikoPulloverHoodieColor();
        cart.addProductToCart();
        cart.viewShoppingCart();
        ActionHelper.talkScreenshot(driver);
    }
    @Test
    //checking out to complete the order
    public void checkingOut(){
        test = extent.createTest("TC-002:Product Comparison", "Verify if a user not logged in can add product to compare products details view");

        checkout.clickProceedToCheckout();
        checkout.setEmail();
        checkout.setFirstName();
        checkout.setLastName();
        checkout.setCompany();
        checkout.setAddress();
        checkout.setCity();
        checkout.clickProvince();
        checkout.setCode();
        checkout.clickCountry();
        checkout.setPhone();
        checkout.clickShippingMethod();
        checkout.clickNextButton();
        placeOrder.clickPlaceOrder();
    }
    @AfterTest
    //tearDown
    public void tearDown(){
        driver.quit();
        extent.flush();
    }
}
