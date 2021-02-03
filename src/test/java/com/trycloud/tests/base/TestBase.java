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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getKeyValue("Environment"));


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
        userNameInputField.clear();
        userNameInputField.sendKeys(ConfigurationReader.getKeyValue("userName1"));

        WebElement passwordInputField = xPath("//input[@id='password']");
        passwordInputField.clear();
        passwordInputField.sendKeys(ConfigurationReader.getKeyValue("password") + Keys.ENTER);
    }


    @AfterMethod
    public void teardown() {
        sleep(3);
        driver.close();

    }


}
