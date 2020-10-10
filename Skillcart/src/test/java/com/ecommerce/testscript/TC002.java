package com.ecommerce.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC002 {
	@Test(description="Test selected item is there in cart")
	  public void addItem()
	  {
	 System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		 driver.findElement(By.partialLinkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("nameishemanth@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Testing@123");
		 driver.findElement(By.name("SubmitLogin")).click();
		driver.findElement(By.xpath("(//a[text()='Dresses'])[2]")).click();
		
       
	  }}
