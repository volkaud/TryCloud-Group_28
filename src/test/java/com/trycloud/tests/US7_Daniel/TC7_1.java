package com.trycloud.tests.US7_Daniel;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC7_1 extends TestBase {


    @Test
    public void TC1(){
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


}
