package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestaLivrosUnico {
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
  public void testALivrosUnico() throws Exception {
    driver.get("https://www.submarino.com.br/");
    driver.findElement(By.xpath("//img[contains(@src,'chrome-extension://eofcbnmajmjmplflapaojjnihcjkigck/common/ui/icons/close-icon-copy-8.png')]")).click();
    driver.findElement(By.id("h_search-input")).click();
    driver.findElement(By.id("h_search-input")).clear();
    driver.findElement(By.id("h_search-input")).sendKeys("livros");
    driver.findElement(By.id("h_search-input")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//img[@alt='Livro - Dois a Dois']")).click();
    driver.findElement(By.xpath("//img[contains(@src,'chrome-extension://eofcbnmajmjmplflapaojjnihcjkigck/common/ui/icons/close-icon-copy-8.png')]")).click();
    driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[5]/div/section/section[2]/div/table/tbody/tr[5]/td[2]")).click();
    driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[5]/div/section/section[2]/div/table/tbody/tr[3]/td[2]")).click();
    driver.get("http://www.americanas.com.br");
    driver.findElement(By.id("h_search-input")).click();
    driver.findElement(By.id("h_search-input")).clear();
    driver.findElement(By.id("h_search-input")).sendKeys("9788580417012");
    driver.findElement(By.id("h_search-btn")).click();
    driver.findElement(By.xpath("//img[@alt='Livro - Dois a Dois']")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [runScript | window.scrollTo(0,2600) | ]]
    driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[3]")).click();
    driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[2]/td[2]")).click();
    assertEquals("9788580417012", driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[2]/td[2]")).getText());
    assertEquals("Nicholas Sparks", driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[3]/td[2]")).getText());
    try {
      assertEquals("Harlan Coben", driver.findElement(By.xpath("//div[@id='content']/div/main/div[2]/div[4]/div/section/section[2]/div/table/tbody/tr[3]/td[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.get("http://livrariacultura.com.br");
    driver.findElement(By.id("Ntt-responsive")).click();
    driver.findElement(By.id("Ntt-responsive")).clear();
    driver.findElement(By.id("Ntt-responsive")).sendKeys("9788580417012");
    driver.findElement(By.id("searchForm")).submit();
    driver.findElement(By.xpath("//img[@alt='Livro - DOIS A DOIS']")).click();
    assertEquals("SPARKS, NICHOLAS", driver.findElement(By.linkText("SPARKS, NICHOLAS")).getText());
    // ERROR: Caught exception [ERROR: Unsupported command [runScript | window.scrollTo(0,1000) | ]]
    assertEquals("Harlan Coben", driver.findElement(By.linkText("SPARKS, NICHOLAS")).getText());
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
