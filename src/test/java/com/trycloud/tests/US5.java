package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase_v2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class US5 extends TestBase_v2 {

  List<String> contactNames = new ArrayList<String>();

  @Test
  //Test case #1 - verify users can access to Talks module
  public void TC5_1() {
  //  1.Login as a user
    // **********  already logged in from @BeforeClass
  //  2.Click “Contacts” module
    WebElement target = xPath("//ul[@id='appmenu']");
    action.moveToElement(target).perform();
    sleep(1);
    xPath("//ul[@id='appmenu']//span[contains(text(), 'Contacts')]").click();
  //  3.Verify the page tile is Contents module’s tile
    String expectedTitle = "Contacts";
    String actualTitle = driver.getTitle();

    Assert.assertTrue(actualTitle.contains(expectedTitle));
  }

  @Test(dependsOnMethods = {"TC5_1"})
  //Test case #2 - verify users can add contacts
  public void TC5_2(){
    // 1.Login as a user
      // **********  already logged in from @BeforeClass
    // 2.Click contacts module
      // ********** already clicked in TC5_1()
    // create new contact
    contactNames.add(createContact());
    // 5.Verify the contact name is added to the contact list
    String actualName = xPath("//div[@class='app-content-list-item-line-one']").getText();

    Assert.assertEquals(actualName, contactNames.get(0), "FAIL to add new contact");
  }

  private String createContact(){
    // 3.Click “New Contact” button
    xPath("//div[@id='app-navigation-vue']/a").click();
    sleep(1);
    xPath("//button[@id='new-contact-button']").click();
    sleep(1);
    // 4.Fill out the contact info like : Title, Phone, email, address , etc
    Faker faker = new Faker();
    String fullName = faker.name().fullName();
    sleep(1);
    xPath("//input[@id='contact-org']").sendKeys(
            faker.company().name()
    );
    sleep(1);
    xPath("//input[@id='contact-title']").sendKeys(
            faker.name().title()
    );
    sleep(1);
    xPath("//input[@id='contact-fullname']").sendKeys(fullName);
    sleep(1);
    xPath("//input[@inputmode='tel']").sendKeys(faker.phoneNumber().cellPhone());
    sleep(1);
    xPath("//input[@inputmode='email']").sendKeys(faker.internet().emailAddress());
    sleep(1);
    xPath("//div[contains(text(), 'Address')]/following-sibling::input").sendKeys(
            faker.address().streetAddress()
    );
    sleep(1);
    xPath("//div[contains(text(), 'Postal code')]/following-sibling::input").sendKeys(
            faker.address().zipCode()
    );
    sleep(1);
    xPath("//div[contains(text(), 'City')]/following-sibling::input").sendKeys(
            faker.address().city()
    );
    sleep(1);
    xPath("//div[contains(text(), 'State or province')]/following-sibling::input").sendKeys(
            faker.address().state()
    );
    sleep(1);
    xPath("//div[contains(text(), 'Country')]/following-sibling::input").sendKeys(
            faker.address().country() + Keys.ENTER
    );
    return fullName;
  }

  @Test(dependsOnMethods = {"TC5_2"})
  // Test case #3 - verify users can see all the contact names on the contact list
  public void TC5_3(){
    // 1.Login as a user
    // **********  already logged in from @BeforeClass
    // 2.Click contacts module
    // ********** already clicked in TC5_1()
    // create some contacts
    contactNames.add(createContact());
    contactNames.add(createContact());
    // 3.Verify the contact names are in the list
    List<WebElement> contacts = xPathList(
            "//div[@class='vue-recycle-scroller__item-wrapper']/div"
    );
    for (WebElement contact : contacts) {
      String currentName = contact.findElement(
              By.xpath(".//div[@class='app-content-list-item-line-one']"
              )).getText();
      Assert.assertTrue(contactNames.contains(currentName), "Fail to add contact by name: " + currentName);
    }
  }
}
