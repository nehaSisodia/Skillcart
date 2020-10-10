package com.ecommerce.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
	public WebDriver driver;
	 Actions action;
	 JavascriptExecutor js;
	 WebDriverWait wait;
	 public WebDriverUtility(WebDriver driver , long Eto)
	 {
		 this.driver=driver;
	   wait=new WebDriverWait(driver, Eto);
	 }
	public void webdriverutil(WebDriver driver, long Eto)
	{
		this.driver=driver;
		action=new Actions(driver);
		js=(JavascriptExecutor)driver;
	
	}
	public void click(WebElement target)
	{
		try {
	
        wait.until(ExpectedConditions.elementToBeClickable(target));
	    target.click();
		}
		catch(Exception e) {
	    boolean isClicked=false;
	    scrollToView(target);
	    int i=1;
	    		for(i=1;i<=3;i++)
	    		{
	    			try {
	    		target.click();	 
	    		isClicked=true;
	              break;
	    		}
	    			catch(Exception e1)
	    		{
	    			jsClick(target);
	    		}
	         }
		  }
	 }
	
	public void jsClick(WebElement target)
	{
		js.executeScript("argument[0].click();", target);
		}
	public void scrollToView(WebElement target)
	{
		js.executeScript("arguments[0].scrollIntoView();", target);
	}
  
	public boolean waituntilElemetNotDisplayed(By xpath)
	{
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));
	}

    public void moveToElement(WebElement target)
	{
		action.moveToElement(target).click().perform();
	}
	public void selectByVisibleText(WebElement target,String visibleText)
	{
		Select select=new Select(target);
		select.selectByVisibleText(visibleText);
	}
	public void selectByValue(WebElement target,String value)
	{
		Select select=new Select(target);
		select.selectByVisibleText(value);
	}
	public void selectByValueListBox(WebElement target,String value)
	{
		Select select=new Select(target);
		List<WebElement> listBox=select.getOptions();
		for(WebElement selectElement : listBox)
		{
			String elementSelect=selectElement.getText();
			if(elementSelect.equalsIgnoreCase(value))
			{
			 select.selectByValue(elementSelect);
	   }
	}}
	public void selectByTextListBox(WebElement target,String value)
	{
		Select select=new Select(target);
		List<WebElement> listBox=select.getOptions();
		for(WebElement selectElement : listBox)
		{
			String elementSelect=selectElement.getText();
			if(elementSelect.equalsIgnoreCase(value))
			{
		   select.selectByVisibleText(elementSelect);
	}
	}}
	public void selectByIndex(WebElement target,int index)
	{
		Select select=new Select(target);
		select.selectByIndex(index);
	}
	
	public void enterKeyword(WebElement target,String keywords)
	{
		target.sendKeys(keywords);
	}
	public void rightClick(WebElement target)
	{
		action.contextClick(target).perform();
	}
	
	public void scrollDown(int pixel)
	{
		js.executeScript("window.scrollBy(0,"+pixel+");");
	}
	
	public void scrollUp(int pixel)
	{
		js.executeScript("window.scrollBy(0,-"+pixel+");");
	}
	public void dragAndDrop(WebElement src,WebElement target)
	{
		action.dragAndDrop(src, target).perform();
	}
}
	
	
	
	
	
	
	
	
	
	