package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPages {
    WebDriver driver;
    WebDriverWait driverWait;

    public LoginPages(WebDriver driver) {
        this.driver = driver;
        System.out.println("check the driver is exist" + driver);
    }


    public void setUser(){
        WebElement usernameOpt = driver.findElement(By.cssSelector("[ng-click=\"customer()\"]"));
        usernameOpt.click();

        System.out.println("1. Click the Customer Login Button");
    }

    public void selectUser(){
        WebElement dropdown = driver.findElement(By.id("userSelect"));
        Select idDropDown = new Select(dropdown);

        System.out.println("2. Click the user dropdown");

        idDropDown.selectByIndex(1);
        System.out.println("3. User is selected");

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonLogin = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        buttonLogin.click();

        System.out.println("4. Login button is clicked");


        // Assert user is logged in
        WebElement welcomeText = driver.findElement(By.xpath("//strong[contains(.,'Welcome')]"));
        System.out.println("here is the welcome text" + welcomeText.getText());
        String welcome = welcomeText.getText();
        Assert.assertTrue(welcome.contains("Welcome"), "but the fact is ??"+ welcome);

        System.out.println("5. user is logged in: " + welcome);
    }

    public void clickLogin(){
        setUser();
        selectUser();
    }
}
