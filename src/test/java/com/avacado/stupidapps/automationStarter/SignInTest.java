package com.avacado.stupidapps.automationStarter;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInTest
{

  static WebDriver driver;
  
  @BeforeClass
  public static void initDriver()
  {
    final File file = new File("D:\\src\\driver\\chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    driver = new ChromeDriver();
  }
  
  @Test
  public void testSignIn() throws InterruptedException
  {
    driver.get("http://automationpractice.com");
    driver.manage().window().maximize();
    WebElement signInLink = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a"));
    signInLink.click();
    Thread.sleep(10000L);
    
    WebElement emailField = driver.findElement(By.id("email"));
    emailField.sendKeys("testuser@testuser.com");
    WebElement passwdField = driver.findElement(By.id("passwd"));
    passwdField.sendKeys("testuser1029");
    WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
    signInButton.click();
    Thread.sleep(10000L);
    
    WebElement signedInUserName = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span"));
    String userName = signedInUserName.getText();
    Assert.assertEquals(userName, "Test user");
  }
  
  @AfterClass
  public static void destroyDriver()
  {
    driver.close();
    driver.quit();
  }
}
