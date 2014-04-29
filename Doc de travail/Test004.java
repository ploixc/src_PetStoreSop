package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ListeDesActionsDeLaPagePrincipale {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testListeDesActionsDeLaPagePrincipale() throws Exception {
    driver.get(baseUrl + "/shop/signoff.do");
    driver.findElement(By.xpath("//tr[2]/td/a/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//tr[3]/td/a/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//tr[4]/td/a/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//tr[5]/td/a/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//tr[6]/td/a/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.cssSelector("area[alt=\"Fish\"]")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.cssSelector("area[alt=\"Dogs\"]")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.cssSelector("area[alt=\"Reptiles\"]")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.cssSelector("area[alt=\"Cats\"]")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//area[6]")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.cssSelector("center > a > img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//center/a[2]/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//center/a[3]/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//a[4]/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.xpath("//a[5]/img")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.name("img_cart")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.name("img_help")).click();
    driver.findElement(By.cssSelector("img")).click();
    driver.findElement(By.name("keyword")).clear();
    driver.findElement(By.name("keyword")).sendKeys("koi");
    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
    driver.findElement(By.cssSelector("font")).click();
    driver.findElement(By.name("img_signin")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("toto");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("toto");
    driver.findElement(By.xpath("//center[2]/a/img")).click();
    driver.findElement(By.name("account.username")).clear();
    driver.findElement(By.name("account.username")).sendKeys("toto");
    driver.findElement(By.name("account.password")).clear();
    driver.findElement(By.name("account.password")).sendKeys("toto");
    driver.findElement(By.name("repeatedPassword")).clear();
    driver.findElement(By.name("repeatedPassword")).sendKeys("toto");
    driver.findElement(By.name("account.firstName")).clear();
    driver.findElement(By.name("account.firstName")).sendKeys("first");
    driver.findElement(By.name("account.lastName")).clear();
    driver.findElement(By.name("account.lastName")).sendKeys("last");
    driver.findElement(By.name("account.email")).clear();
    driver.findElement(By.name("account.email")).sendKeys("email");
    driver.findElement(By.name("account.phone")).clear();
    driver.findElement(By.name("account.phone")).sendKeys("02020202");
    driver.findElement(By.name("account.address1")).clear();
    driver.findElement(By.name("account.address1")).sendKeys("8 rue adresse");
    driver.findElement(By.name("account.address2")).clear();
    driver.findElement(By.name("account.address2")).sendKeys("8 rue adresse2");
    driver.findElement(By.name("account.city")).clear();
    driver.findElement(By.name("account.city")).sendKeys("ruaudin");
    driver.findElement(By.name("account.state")).clear();
    driver.findElement(By.name("account.state")).sendKeys("pays de loire");
    driver.findElement(By.name("account.zip")).clear();
    driver.findElement(By.name("account.zip")).sendKeys("72230");
    driver.findElement(By.name("account.country")).clear();
    driver.findElement(By.name("account.country")).sendKeys("france");
    new Select(driver.findElement(By.name("account.favouriteCategoryId"))).selectByVisibleText("Cats");
    driver.findElement(By.name("submit")).click();
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
