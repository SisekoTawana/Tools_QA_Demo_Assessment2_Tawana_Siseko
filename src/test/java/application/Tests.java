package application;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.xmlbeans.impl.xb.ltgfmt.Code;
import org.checkerframework.checker.units.qual.C;
import org.etsi.uri.x01903.v13.CertIDType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ActionHelper;
import utilities.ExcelHelper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Tests {
    public static WebDriver driver;
    ExtentSparkReporter htmlReport;
    ExtentReports extent;
    public static ExtentTest test;
    ExcelHelper excelData;
    Home home;
    Product products;
    CompareProducts compareProducts;
    ProductDetails productDetails;
    Cart cart;
//    Search search;
    Checkout checkout;
    PlaceOrder placeOrder;
    Link link;
    private String emailData;
    private String passwordData;
    private String FirstName;
    private String LastName;
    private String Company;
    private String Address;
    private String City;
    private String Province;
    private String Code;
    private String Country;
    private String Phone;
    @Parameters({"browser", "url"})
    @BeforeTest
    //setting up WebDriver & extentReports
    public void setUp(String browser, String url) {
        try {

            if (browser.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(options);
            } else {
                throw new RuntimeException("Browser name '" + browser + "'could not be found. Check spelling");
            }

            driver.manage().window().maximize();

            ExtentReports extentReports = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("LumaTestReport.html");
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("Browser", browser);
            extentReports.setSystemInfo("URL", url);

            String fileSeparator = System.getProperty("file.separator");
            String file = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "java" + fileSeparator + "reporting" + fileSeparator + "LumaTestReport_"
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HH.mm.ss")) + ".html";
            htmlReport = new ExtentSparkReporter(file);
            extent = new ExtentReports();
            extent.attachReporter(htmlReport);
            //ExtentReports - configuration items to change the look and feel
            htmlReport.config().setDocumentTitle("Demo shop Automation Report 2");
            htmlReport.config().setReportName("Test Report");
            htmlReport.config().setTheme(Theme.DARK);
            htmlReport.config().setTimeStampFormat("EEEE, MMM dd, yyyy, hh:mm a '('zzz')'");
        } catch (Exception e) {
            Assert.fail("something went wrong during setup " + e);
            throw new RuntimeException(e);
        }

        excelData = new ExcelHelper();
        excelData.setupExcel();
    }
    @AfterMethod
    public void testResults(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            if (test != null) {
                test.log(Status.PASS, result.getTestName());
            }
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (test != null) {
                test.log(Status.FAIL, result.getThrowable());
            }
        } else {
            if (test != null) {
                test.log(Status.SKIP, result.getTestName());
            }
        }
    }


    @Test(priority = 1)
    //add Radiant Tee
    public void addRadiantTee() throws InterruptedException, IOException {
        link = new Link(driver);
        home = new Home(driver);
        compareProducts = new CompareProducts(driver);
        products= new Product(driver);
        test = extent.createTest("TC-001:","Verify if a user not logged in can add product to compare multiple products view");

        test.info("Go to the website");
        link.goTo();
        test.info("Hovering and Clicking Radiant Tee");
        home.navigateToHomePage();
        Thread.sleep(2000);
        products.addRadiantTee();
        Thread.sleep(2000);
        compareProducts.clickComparisonList();
        Thread.sleep(2000);
        test.log(Status.INFO,"Adding and clicking the product to comparison list");
        test.log(Status.INFO,"Taking a screenshot");
        ActionHelper.talkScreenshot(driver);
    }

    @Test(priority = 2)
    //add Breathe Easy Tank
    public void addBreatheEasyTank() throws InterruptedException, IOException{
        home = new Home(driver);
        products = new Product(driver);
        compareProducts = new CompareProducts(driver);
        test = extent.createTest("TC-002:", "Verify if a user not logged in can add product to compare products details view");

        home.navigateToHomePage();
        Thread.sleep(2000);
        test.info("Hovering and Clicking Breathe Easy Tank");
        products.addBreatheEasyTank();
        Thread.sleep(2000);
        compareProducts.clickAddToCompare();
        Thread.sleep(2000);
        compareProducts.clickComparisonList();
        test.log(Status.INFO,"Adding the Breathe Easy Tank to comparison list");
        Thread.sleep(2000);
        test.log(Status.INFO,"Taking a screenshot");
        ActionHelper.talkScreenshot(driver);
    }

    @Test(priority = 3)
    public void addAndRemoveArgusAllWeatherTank() throws InterruptedException, IOException{
        home = new Home(driver);
        products = new Product(driver);
        compareProducts = new CompareProducts(driver);
        test = extent.createTest("TC-003: Product Comparison", "Verify if a product can be removed from compare product list");

        home.navigateToHomePage();

        Thread.sleep(2000);
        test.info("Hovering and Clicking Argus All-Weather Tank");
        products.addArgusAllWeatherTank();
        Thread.sleep(2000);
        compareProducts.clickAddToCompare();
        Thread.sleep(2000);
        compareProducts.clickComparisonList();
        test.log(Status.INFO,"Adding  and Removing the Breathe Easy Tank to comparison list");
        Thread.sleep(2000);
        ActionHelper.talkScreenshot(driver);
        compareProducts.removeToCompareList();
        ActionHelper.talkScreenshot(driver);
        Thread.sleep(2000);
        compareProducts.clickOkButton();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    //add product to cart
    public void addProductToCart() throws InterruptedException, IOException{
        link = new Link(driver);
        home = new Home(driver);
        products = new Product(driver);
        productDetails = new ProductDetails(driver);
        cart = new Cart(driver);
        test = extent.createTest("TC-004: Add Product To Cart", "Check user not logged in can add a product to the shopping cart");

        /*assertEquals(passMessage.verifyLoginPass(), "Welcome", home.verifyLoginPass());*/
        test.info("Adding Hero Hoodie to Cart and viewing the shopping cart");
        products.addHeroHoodie();
        Thread.sleep(2000);
        productDetails.clickHeroHoodieSize();
        Thread.sleep(2000);
        productDetails.clickHeroHoodieColor();
        Thread.sleep(2000);
        cart.addProductToCart();
        Thread.sleep(2000);
        cart.viewShoppingCart();
        Thread.sleep(2000);
        ActionHelper.talkScreenshot(driver);
    }

    @Test(priority = 5)
    //add 3-star product to cart
    public void add3StarProductToCartWhileLoggedIn() throws InterruptedException, IOException{
        link = new Link(driver);
        home = new Home(driver);
        cart = new Cart(driver);
        products = new Product(driver);
        test = extent.createTest("TC-005: Add 3 star Product To Cart", "Verify if a user logged in can add product to compare multiple products view withouth selecting its size and colour");
        emailData = excelData.getCellData(1,0);
        passwordData = excelData.getCellData(1,1);

        test.info("Signing in ");
        home.navigateToHomePage();
        Thread.sleep(2000);
        home.clickSignInLink();
        Thread.sleep(2000);
        home.setEmailAddress(emailData);
        Thread.sleep(2000);
        home.setPassword(passwordData);
        Thread.sleep(2000);
        ActionHelper.talkScreenshot(driver);
        home.clickSignIn();
        Thread.sleep(2000);
        home.navigateToHomePage();
        Thread.sleep(2000);
        test.info("Navigating and clicking tees");
        home.navigateToTeesAndClick();
        Thread.sleep(2000);
        products.clickThreeStarProduct();
        Thread.sleep(2000);
        test.info("Adding a 3 star product to Cart");
        cart.add3StarProductToCart();
        ActionHelper.talkScreenshot(driver);
    }

    @Test(priority = 6)
    //add Miko Pullover Hoodie
    public void addMikoPulloverHoodie() throws InterruptedException, IOException{
        home = new Home(driver);
        products = new Product(driver);
        productDetails = new ProductDetails(driver);
        cart = new Cart(driver);
        test = extent.createTest("TC-006: Add Miko Pullover Hoodie", "Verify if a user logged in can add product");

        home.navigateToHomePage();
        Thread.sleep(2000);
        test.info("Clicking the product");
        products.clickMikoPulloverHoodie();
        Thread.sleep(2000);
        productDetails.clickMikoPulloverHoodieSize();
        Thread.sleep(2000);
        productDetails.clickMikoPulloverHoodieColor();
        Thread.sleep(2000);
        test.info("Adding product to Cart");
        cart.addProductToCart();
        Thread.sleep(2000);
        cart.viewShoppingCart();
        Thread.sleep(2000);
        ActionHelper.talkScreenshot(driver);
    }

    @Test(priority = 7)
    //checking out to complete the order
    public void checkingOut() throws InterruptedException, IOException{
        checkout = new Checkout(driver);
        home = new Home(driver);

        emailData = excelData.getCellData(1,0);
        FirstName = excelData.getCellData(1, 2);
        LastName = excelData.getCellData(1, 3);
        Company = excelData.getCellData(1, 4);
        Address = excelData.getCellData(1, 5);
        City = excelData.getCellData(1, 6);
        Province = excelData.getCellData(1, 7);
        Code = excelData.getCellData(1, 8);
        Country = excelData.getCellData(1, 9);
        Phone = excelData.getCellData(1, 10);

        checkout.clickProceedToCheckout();
        home.setEmailAddress(emailData);
        checkout.setFirstName(FirstName);
        checkout.setLastName(LastName);
        checkout.setCompany(Company);
        checkout.setAddress(Address);
        checkout.setCity(City);
        checkout.clickCountry(Country);
        checkout.clickProvince(Province);
        checkout.setCode(Code);
        checkout.setPhone(Phone);
//        checkout.clickShippingMethod();
        checkout.clickNextButton();
        placeOrder.clickPlaceOrder();
    }

    @AfterTest
    //tearDown
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
        /*public String takeScreenshot(WebDriver driver, String screenshotName)
        throws IOException, IOException {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = "C:\\Users\\Digi_WS\\Tools_QA_Demo_Assessment2_Tawana_Siseko\\Screenshots\\Screenshots" + screenshotName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            return destination;
        }*/
    }

