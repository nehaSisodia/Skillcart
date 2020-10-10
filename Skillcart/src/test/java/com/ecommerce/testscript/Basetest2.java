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
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;

public class Basetest2 implements Autoconstant{

	public WebDriver driver;
	   public HomePage hp;
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

	     @Parameters({"un", "pd"})
	     @BeforeMethod
	     public void loginToApp(@Optional (DEFAULT_USERNAME)String user , @Optional(DEFAULT_PASSWORD)String pwd)
	     {
		 LoginPage lp=new LoginPage(driver, wp);
		 
		 user=PropertyFile.getDataFromProperty("un");
		 pwd=PropertyFile.getDataFromProperty("pd");
		 hp=  lp.login(user, pwd);
		  }
		
	  // @AfterMethod
	  // public void logOutApp()
	  // {//
		  // orderPage odp=new orderPage(driver, wp);
		   //odp.logOut();
	//   }
	  // @AfterClass
	   //public void closeApp()
	  // {
	//	   driver.close();
	  // }
	   }


