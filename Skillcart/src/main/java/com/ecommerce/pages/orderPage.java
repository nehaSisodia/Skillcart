package com.ecommerce.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.Reporter;

import com.ecommerce.generic.WebDriverUtility;

public class orderPage extends BasePage{

	String deletItemPath="//a[contains(@href,'id_product=pid')]/../..//i[@class='icon-trash']";
	
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement orderCheckOut;
	
	@FindBy(xpath="//tbody//tr/td/a")
	private List<WebElement > productList;
	
	@FindBy(xpath="//a[@title='Log me out']")
	private WebElement signOut;
	
	public orderPage(WebDriver driver , WebDriverUtility wp)
	{
		super(driver,wp);
	}
	
	public void deletItem(String selectProduct_id )
  {
		if(isProductDisplayed(selectProduct_id))
		{
		deletItemPath=deletItemPath.replace("pid", selectProduct_id)	;
	    wp.click(driver.findElement(By.xpath(deletItemPath)));
	    //Reporter.log("item delet successfully",true);
		}
	}
	
	public void proceedCheckOut()
	{
		wp.click(orderCheckOut);
	}
	public boolean isProductDisplayed(String selectProduct_id)
	{
		 selectProduct_id="id_product="+selectProduct_id;
		for(WebElement product: productList)
		{
			if(product.getAttribute("href").contains(selectProduct_id))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isProductNotDisplayed(String selectProduct_id)
	{
		selectProduct_id="id_product="+selectProduct_id;
		String path="//a[contains(@href,'id+product="+selectProduct_id+"')]";
		try {
		  //   Reporter.log("product is presenrt",true);
		    return wp.waituntilElemetNotDisplayed(By.xpath(path));
     }
		catch(NoSuchElementException e)
		{
			//Reporter.log(e.toString(),true);
		}
		return false;
	}
	
	
}
