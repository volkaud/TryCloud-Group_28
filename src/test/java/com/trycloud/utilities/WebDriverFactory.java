package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

   public static WebDriver getDriver(String browserName){

       if( browserName.equalsIgnoreCase("firefox")){
           WebDriverManager.firefoxdriver().setup();
           return  new FirefoxDriver();
       } else if(browserName.equalsIgnoreCase("chrome")){
           WebDriverManager.chromedriver().setup();
           return new ChromeDriver();

       } else if(browserName.equalsIgnoreCase("opera")){
           WebDriverManager.operadriver().setup();
           return  new OperaDriver();
       }else{
           System.err.println("Incorrect browser name");
           return null;
       }


   }
}
