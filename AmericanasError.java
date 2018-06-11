package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AmericanasError {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAmericanasError() throws Exception {
    driver.get("https://www.americanas.com.br/");
    driver.findElement(By.id("h_search-input")).click();
    driver.findElement(By.id("h_search-input")).clear();
    driver.findElement(By.id("h_search-input")).sendKeys("9788580417012");
    driver.findElement(By.id("h_search-btn")).click();
    driver.findElement(By.xpath("//img[@alt='Livro - Dois a Dois']")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [runScript | window.scrollTo(0,2600) | ]]
    driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[3]")).click();
    driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[2]/td[2]")).click();
    assertEquals("9788580417012", driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[2]/td[2]")).getText());
    assertEquals("Harlan Coben", driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[3]/td[2]")).getText());
    // ERROR: Caught exception [unknown command []]
    // ERROR: Caught exception [unknown command []]
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
