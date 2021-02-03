package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US4 extends TestBase {  //Story: As a user, I should be able to access to Talks module.


    @Test
    //Test case #1 - verify users can access to Talks module
    public void TC4_1() {

        loginTryCloud();

        //1. Login as a user ---> Executed on "BeforeMethod" using loginTryCloud() custom method

        //2. Click Talks module
        WebElement talksModule = xPath("//ul[@id = 'appmenu']/li[4]/a");
        ///html/body/header/div[1]/ul/li[4]/a
        talksModule.click();
        sleep(2);

        //3. Verify the page tile is Talks module’s tile


    }

    @Test
    //Test case #2 - verify users can send message
    public void TC4_2() {

        loginTryCloud();

        //1. Login as a user ---> Executed on "BeforeMethod" using loginTryCloud() custom method

        //2. Click Talks module
        WebElement talksModule = xPath("//ul[@id = 'appmenu']/li[4]/a");
        ///html/body/header/div[1]/ul/li[4]/a
        talksModule.click();
        sleep(2);

        //3. Search a user from search box on the left
        WebElement searchTalksModule = xPath("//div[@id = 'content-vue']/div[1]/a");
        searchTalksModule.click();

        WebElement searchTalksBox = xPath("//input[@type = 'text']");
        searchTalksBox.sendKeys(ConfigurationReader.getKeyValue("talkSearchBoxUser"));

        //4. Write a message
        WebElement messageButton = xPath("//div[@class = 'wrapper']/button[1]");
        messageButton.click();

        WebElement conversationName = xPath("//input[@class = 'conversation-name']");
        conversationName.sendKeys(ConfigurationReader.getKeyValue("conversationName"));

        WebElement addParticipantsButton = xPath("//button[@class = 'navigation__button navigation__button-right primary']");
        addParticipantsButton.click();

        WebElement searchParticipants = xPath("//input[@class = 'set-contacts__input']");
        searchParticipants.sendKeys(ConfigurationReader.getKeyValue("talkSearchBoxUser"));

        WebElement addUser = xPath("//li[@class = 'participant-row']");
        addUser.click();

        WebElement createConversationButton = xPath("//button[@class = 'navigation__button navigation__button-right primary']");
        createConversationButton.click();

        WebElement messageBox = xPath("//div[@class= 'new-message-form__advancedinput']");
        messageBox.sendKeys(ConfigurationReader.getKeyValue("messageBox"));

        //5. Click submit button

        WebElement submitButton = xPath("//button[@class= 'new-message-form__button submit icon-confirm-fade']");
        submitButton.click();

        //6. Verify the message is displayed on the conversation log

        String expectedMessage = ConfigurationReader.getKeyValue("messageBox");

        WebElement message = xPath("//div[@id=\"message_877\"]/div[2]/div[1]/div");
        String actualMessage = message.getText();

        Assert.assertTrue(actualMessage.equals(expectedMessage),"Message is not displayed");

    }


}



