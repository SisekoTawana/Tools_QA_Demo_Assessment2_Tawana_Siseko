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
    Tees tees;

    public Tests(){
        home = new Home();
        tees = new Tees();
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
    //invalid login test
    public void invalidLogin(String url){
        test.createNode("invalid login test", "TC-001");
    home.navigateToHomePage(url);
    home.captureCredentialsAndSubmit();
    home.verifyLoginFails();
}
    @Test
    //valid login
    public void validLogin(String url){

    }
    @Test
    //add to cart
    public void addToCompareList(String url){
        tees.addRadiantTeeWhileNotLoggedIn();
        tees.addBreatheEasyTankWhileNotLoggedIn();
        tees.
    }
    @Test
    //add 3 star to cart
    public void add3StarToCart(String url){

    }
    @Test
    //add Miko Pullover Hoodie
    public void addMikoPulloverHoodie(String url){

    }
    @AfterTest
    //tearDown
    public void tearDown(){
        driver.quit();
        extent.flush();
    }
}
