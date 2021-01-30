package com.trycloud.tests.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class testBase {

  public WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getKeyValue("browser"));
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getKeyValue("Environment"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);

    }


    public void sleep(double seconds){
        try {
            Thread.sleep((long)seconds*1000);
        } catch (InterruptedException e) {
            System.out.println("Fix your sleep input");
        }
    }

    // created an xPath method for easier input of the xpath
    public WebElement xPath (String xpath){
        return driver.findElement(By.xpath(xpath));
    }


    @AfterMethod
    public void teardown(){
        driver.close();
    }


}
