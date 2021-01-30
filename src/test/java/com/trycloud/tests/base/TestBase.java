package com.trycloud.tests.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getKeyValue("browser"));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getKeyValue("Environment"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

    }


    public void sleep(double seconds) {
        try {
            Thread.sleep((long) seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Fix your sleep input");
        }
    }

    // created an xPath method for easier input of the xpath
    public WebElement xPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }


    public void loginTryCloud() {
        WebElement userNameInputField = xPath("//input[@id='user']");
        userNameInputField.sendKeys("User28");

        WebElement passwordInputField = xPath("//input[@id='password']");
        userNameInputField.sendKeys("Userpass123" + Keys.ENTER);
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }


}
