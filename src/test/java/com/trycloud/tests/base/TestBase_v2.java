package com.trycloud.tests.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase_v2 {
  public WebDriver driver;
  public Actions action;

  @BeforeClass
  public void  setupClass(){
    driver = WebDriverFactory.getDriver(ConfigurationReader.getKeyValue("browser"));
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    driver.get(ConfigurationReader.getKeyValue("Environment"));
    action = new Actions(driver);
    sleep(1);
    loginTryCloud();
  }

  @AfterClass
  public void tearDownClass(){
    driver.close();
  }

  public void sleep(double seconds) {
    try {
      Thread.sleep((long) seconds * 1000);
    } catch (InterruptedException e) {
      System.out.println("Fix your sleep input");
    }
  }

  public void loginTryCloud() {
    WebElement userNameInputField = xPath("//input[@id='user']");
    userNameInputField.clear();
    userNameInputField.sendKeys(ConfigurationReader.getKeyValue("userName1"));
    sleep(2);

    WebElement passwordInputField = xPath("//input[@id='password']");
    passwordInputField.clear();
    passwordInputField.sendKeys(ConfigurationReader.getKeyValue("password") + Keys.ENTER);
    sleep(2);
  }

  // created an xPath method for easier input of the xpath
  public WebElement xPath(String xpath) {
    return driver.findElement(By.xpath(xpath));
  }

  // created an xPath method for easier input of the xpath
  public List<WebElement> xPathList(String xpath) {
    return driver.findElements(By.xpath(xpath));
  }

  public WebElement cssSel(String value ){
    return driver.findElement(By.cssSelector(value));
  }

  public List<WebElement> cssSels(String value) { return driver.findElements(By.cssSelector(value));}
}
