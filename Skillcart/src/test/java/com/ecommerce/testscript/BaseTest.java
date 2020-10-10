package com.ecommerce.testscript;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ecommerce.generic.Autoconstant;
import com.ecommerce.generic.PropertyFile;
import com.ecommerce.generic.WebDriverUtility;
import com.ecommerce.pages.LoginPage;

public class BaseTest implements Autoconstant{

	public WebDriver driver;
	  
	   public WebDriverUtility wp;
		@Parameters({"appurl"," browser","implicit","explicit"})
		@BeforeClass
		public void openApp
		    (@Optional(DEFAULT_URL)String appurl,
					@Optional(DEFAULT_BROWSER)String browser,
					@Optional(ITO)String implicit1,
					@Optional(ETO)String explicit1)
		    {
			
			if(browser.equalsIgnoreCase("chrome"))
			{
			String 	chrome_key=PropertyFile.getDataFromProperty("CHROME_KEY");
			String	chrome_path=PropertyFile.getDataFromProperty("CHROME_PATH");
				System.setProperty(chrome_key,chrome_path);
				driver=new ChromeDriver();
			}
			else
			{
				throw new IllegalArgumentException("Only Chrome and Firefox is Supported");
			}

				//driver.manage().window().maximize();
			   implicit1=PropertyFile.getDataFromProperty("implicit");
				explicit1=PropertyFile.getDataFromProperty("explicit");
				long iTO=Long.parseLong(implicit1);
				long eTO=Long.parseLong(explicit1);
				
				driver.manage().timeouts().implicitlyWait(iTO,TimeUnit.SECONDS);
				appurl=PropertyFile.getDataFromProperty("appUrl");
				driver.get(appurl);
				wp = new WebDriverUtility(driver, eTO);
		   }

	     @Parameters({"un"})
	     @BeforeMethod
	     public void create(@Optional(DEFAULT_USER)String user)
	     {
	    	 LoginPage lp=new LoginPage(driver, wp);
	    	lp.createAccount(user);
	     }
}
	  // @AfterMethod
	  // public void logOutApp()
	  // {//
		  // orderPage odp=new orderPage(driver, wp);
		   //odp.logOut();
	//   }
	  

