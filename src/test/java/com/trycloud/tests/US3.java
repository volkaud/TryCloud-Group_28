package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US3 extends TestBase { //Story: As a user, I should be able to access to Files module.

        @Test
        public void TC3_1Daniel(){
            /*
             Verify users can access to Files module
                1. Login as a user
                2. Verify the page title is Files module’s title
             */
            loginTryCloud();

            WebElement filesFolderModule = xPath("//a[@href='/index.php/apps/files/']");
            filesFolderModule.click();

            Assert.assertTrue(driver.getTitle().contains("Files"));


        }

        @Test
        public void TC3_2Daniel(){
            /*
            Verify users can select all the uploaded files from the page
                1. Login as a user
                2. Click the top left checkbox of the table
                3. Assert all the files are selected

             */
            loginTryCloud();
            WebElement filesFolderModule = xPath("//a[@href='/index.php/apps/files/']");
            filesFolderModule.click();

            WebElement selectAllCheckBoxes = driver.findElement(By.cssSelector("label[for=\"select_all_files\"]"));
            sleep(1);
            selectAllCheckBoxes.click();

            sleep(2);
            List<WebElement> listOfCheckBoxes = driver.findElements(By.xpath("//tbody//td//input[1]"));
            listOfCheckBoxes.forEach(p-> {System.out.println(p);Assert.assertTrue(p.isSelected());});//cant get this to assert

            List<WebElement> listOfTextFromCheckBox = driver.findElements(By.xpath("//tbody//td//span//span[@class='innernametext']"));
            listOfTextFromCheckBox.forEach(p-> {System.out.println(p.getText()); Assert.assertTrue(p.isDisplayed());});

        }




}
