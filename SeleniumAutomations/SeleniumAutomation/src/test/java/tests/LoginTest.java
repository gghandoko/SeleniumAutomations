package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DepositPage;
import pages.LoginPages;

import java.time.Duration;

public class LoginTest extends BaseTest {
    WebDriverWait driverWait;

    @Test
    public void testLogin(){
        LoginPages login = new LoginPages(driver);
        login.clickLogin();


    }
    @Test
    public void testDeposite(){
        Integer amount = 5000;
        LoginPages login = new LoginPages(driver);
        login.clickLogin();

        DepositPage depodepo = new DepositPage(driver);
        depodepo.setDeposit(amount);

        //assert depo berhasil
        depodepo.successDeposit();

    }


}
