package com.trycloud.tests.US7_Daniel;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC7_1 extends TestBase {


    @Test (priority = 1)
    public void TC7_1(){//doesnt work in test enviornment because it doesnt load
        //1. Login as a user
        loginTryCloud();

        sleep(3);
        //2. Click magnifier icon on the right top
        WebElement magnifyingGlassIcon = xPath("//a[@class='header-menu__trigger']");//works
        magnifyingGlassIcon.click();
        sleep(3);

        //3. Search any existing file/folder/user name
        magnifyingGlassIcon.sendKeys("Daniel" + Keys.ENTER); //I created a folder Daniel Bobaniel that it should see
        sleep(3);
        //4. Verify the app displays the expected result option
        WebElement firstVisibleFolderInSearchTable = xPath("//tbody//tr[2]//td[2]");


    }
    //https://app.trycloud.net/index.php/login

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
    }

}
