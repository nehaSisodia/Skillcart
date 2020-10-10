package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecommerce.generic.WebDriverUtility;

public class HomePage extends BasePage
{
  @FindBy(linkText="Women")
  private WebElement womenMenu;
		
  @FindBy(xpath=("(//a[text()='Dresses'])[2]"))
  private WebElement dressesMenu;
  
  @FindBy(linkText="T-shirts")
  private WebElement TshirtMenu;
  
  @FindBy(xpath="//a[@title='Log me out']")
	private WebElement signOut;

  
  public HomePage(WebDriver driver,WebDriverUtility wp)
  {
	  super(driver,wp);
  }
 
  public CatagoryPage menuList(String menuName)
  {
	  switch(menuName)
	  {
	  case "DRESSES" : wp.click(dressesMenu);
	  break;
	  case "WOMEN" : wp.click(womenMenu);
	  break;
	  case "T-SHIRTS" : wp.click(TshirtMenu);
	  }
	 
	  return new CatagoryPage(driver,wp);
  }
 	  
}
