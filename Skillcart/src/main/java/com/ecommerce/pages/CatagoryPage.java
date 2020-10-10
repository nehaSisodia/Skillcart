package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecommerce.generic.WebDriverUtility;

public class CatagoryPage extends BasePage
{
   @FindBy(xpath="// ul[@class='product_list grid row']/li//a[@class='product_img_link']")
   private  List<WebElement> productMenu;
   
   public CatagoryPage(WebDriver driver,WebDriverUtility wp)
   {
	   super(driver,wp);
   }
   public productPage selectItem(String productId)
   {
	   productId="id_product="+productId;
	   for(WebElement product : productMenu)
	   {
		   if(product.getAttribute("href").contains(productId))
		   {
			   wp.click(product);
			   return new productPage(driver,wp);
		   }
		   }
	    return null;
   }
}
