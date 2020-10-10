package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.generic.WebDriverUtility;

public class BasePage 
{
	public WebDriver driver;
	public WebDriverUtility wp;

	public BasePage(WebDriver driver, WebDriverUtility wp)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wp=wp;
	}
	}