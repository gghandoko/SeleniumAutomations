package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class DepositPage {
    WebDriver driver;
    WebDriverWait driverWait;
    public DepositPage(WebDriver driver){
        this.driver = driver;
        System.out.println("check the driver is exist" + driver);
    }

    public void setDeposit(Integer amount){
        //get current balance
        WebElement getCurrentBalance = driver.findElement(By.xpath("//div[@class='center']/strong[2][@class='ng-binding']"));
        String currBalance = getCurrentBalance.getText();
        System.out.println("the balance before was : $" + currBalance);

        //wait until button deposit is displayed
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //click deposit button
        WebElement depositBtn = driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[normalize-space()='Deposit']")));

        System.out.println("check the button" + depositBtn);
        depositBtn.click();
        //input new deposit amount
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputDeposit = driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[type=\"number\"]")));

        inputDeposit.sendKeys(Integer.toString(amount));
        WebElement submitDeposit = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitDeposit.click();

        System.out.println("Successful deposit with: $" + amount + "amount");

        //get balance after deposit
        WebElement getBalanceAfterDepo = driver.findElement(By.xpath("//div[@class='center']/strong[2][@class='ng-binding']"));
        String depoBalance = getBalanceAfterDepo.getText();

        Integer afterDepositBalance;

        //Assert that balance after deposit is match
        afterDepositBalance = Integer.parseInt(currBalance) + amount;
        Assert.assertEquals(afterDepositBalance,Integer.valueOf(depoBalance), "Balance is not match");

        System.out.println("7. Assert the balance after depos is : $" + depoBalance);
    }

    public void successDeposit(){
        WebElement sucessful = driver.findElement(By.cssSelector("[class=\"error ng-binding\"]"));
        String successMessage = sucessful.getText();
        String depositMessage = "Deposit Successful";
        Assert.assertEquals(successMessage,depositMessage, "deposit unsuccessful");
        System.out.println("6. User is successfully deposit");


    }

}
