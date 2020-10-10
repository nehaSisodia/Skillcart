package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecommerce.generic.WebDriverUtility;

public class productPage extends BasePage{

	@FindBy(className="icon-minus")
	  private WebElement minusQuantity;
	
	@FindBy(className="icon-plus")
	  private WebElement plusQuantity;
	
	@FindBy(id="group_1")
	  private WebElement sizeSelection;
	
	@FindBy(name="Submit")
	  private WebElement addToCart;

	@FindBy(xpath="	//ul[@id='color_to_pick_list']/li//a")
	  private List<WebElement> colorMenu;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement checkOut;
	

	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement shopping;
	
	@FindBy(xpath="//span[@title='Close window']")
	private WebElement closeWindow;
	
	public productPage(WebDriver driver,WebDriverUtility wp)
	{
		super(driver,wp);
	}
	public void selectColor(String colorValue)
	{
		colorValue = "color_"+colorValue ;
		for(WebElement color : colorMenu)
		{
			if(color.getAttribute("name").equalsIgnoreCase(colorValue))
			{
				wp.click(color);
				break;
			}
		}
	}
	public void selectSize(String size)
	{
		wp.selectByVisibleText(sizeSelection, size);
	}
	public void addToCartIn()
	{
		wp.click(addToCart);
	}
	public void increaseQuntity(int value)
	{
	  for(int i=1;i<=value ;i++)
		{
				wp.click(plusQuantity);
			}
		}
		
	public void decreaseQuntity(int value)
	{
	   for(int i=1;i<=value ;i++)
		{
				wp.click(minusQuantity);
			}
		}
	public void closePopup()
	{
		wp.click(closeWindow);
		
	}
		
	public void continueShope()
	{
		wp.click(shopping);
	}
	public orderPage proceedFurther()
	{
		wp.click(checkOut);
		return new orderPage(driver,wp);
	}
}
