package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait driverWait;

    @BeforeMethod
    public void setUp(){
        String driverPath = "/src/test/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.drivers", System.getProperty("user.dir") + driverPath);

        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(5));

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/");

    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(10000); // tunggu 10 detik sebelum close
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver != null){
            driver.quit();
        }
    }
}
