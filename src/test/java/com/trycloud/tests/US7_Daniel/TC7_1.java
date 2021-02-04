package com.trycloud.tests.US7_Daniel;

import com.trycloud.tests.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TC7_1 extends TestBase {


    @Test(priority = 1)
    public void TC7_1_qa3Env() throws Exception {//qa3Env
        //1. Login as a user
        loginTryCloud();

        sleep(3);
        //2. Click magnifier icon on the right top
        WebElement magnifyingGlassIcon = xPath("//a[@class='header-menu__trigger']");//works
        magnifyingGlassIcon.click();
        sleep(3);

        //3. Search any existing file/folder/user name
        WebElement inputSearchField = xPath("//div//form//input");


        inputSearchField.sendKeys("Talk" + Keys.ENTER); //I created a folder Daniel Bobaniel that it should see
        sleep(3);
        //4. Verify the app displays the expected result option
        WebElement firstVisibleFolderInSearchTable = xPath("//a[@class='unified-search__result']");
        Assert.assertTrue(firstVisibleFolderInSearchTable.isDisplayed());


        //SCREENSHOT METHOD
        takeSnapShot(driver, "D:\\Users\\User\\Pictures\\ss.png");
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);//driver is the source

        //Move image file to new destination

        File DestFile = new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);
    }

    /*//https://app.trycloud.net/index.php/login
    @Test
    public void TC7_1_ProductionEnv(){//passes
        //1. Login as a user
        loginTryCloud();

        sleep(3);
        //2. Click magnifier icon on the right top
        WebElement magnifyingGlassIcon = xPath("//input[@id='searchbox']");//works
        magnifyingGlassIcon.click();
        sleep(3);
        //3. Search any existing file/folder/user name
        magnifyingGlassIcon.sendKeys("Daniel" + Keys.ENTER); //I created a folder Daniel Bobaniel that it should see
        sleep(3);
        //4. Verify the app displays the expected result option
        WebElement firstVisibleFolderInSearchTable = xPath("//span[@class='innernametext']");
        Assert.assertTrue(firstVisibleFolderInSearchTable.isDisplayed());
    }*/

}
