package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LivrariaCultura {
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
  public void testLivrariaCultura() throws Exception {
    driver.get("https://www.livrariacultura.com.br/index.jsp");
    driver.findElement(By.id("Ntt-responsive")).click();
    driver.findElement(By.id("Ntt-responsive")).clear();
    driver.findElement(By.id("Ntt-responsive")).sendKeys("9788580417012");
    driver.findElement(By.id("searchForm")).submit();
    driver.findElement(By.xpath("//img[@alt='Livro - DOIS A DOIS']")).click();
    assertEquals("SPARKS, NICHOLAS", driver.findElement(By.linkText("SPARKS, NICHOLAS")).getText());
    assertEquals("ABREU, FERNANDA", driver.findElement(By.linkText("ABREU, FERNANDA")).getText());
    // ERROR: Caught exception [ERROR: Unsupported command [runScript | window.scrollTo(0,1000) | ]]
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
