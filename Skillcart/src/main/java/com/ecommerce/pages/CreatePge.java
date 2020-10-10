package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecommerce.generic.WebDriverUtility;

public class CreatePge extends BasePage {

	@FindBy(xpath="(//input[@name='id_gender'])[2]")
	private WebElement radioButton;
	
	@FindBy(id="customer_firstname")
	private WebElement firstName;
	
	@FindBy(id="customer_lastname")
	private WebElement lastName;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="address1")
	private WebElement address;
	
	@FindBy(id="firstname")
	private WebElement fname;
	
	@FindBy(id="lastname")
	private WebElement lname;
	
	@FindBy(id="city")
	private WebElement cityName;
	
	@FindBy(xpath="//select[@id='id_state']")
	private WebElement statelink;
	
	 @FindBy(id="postcode")
	private WebElement zonalCode;
	
   @FindBy(xpath="//select[@id='days']")
	private  WebElement date;

	@FindBy(id="months")
	private WebElement months;
	
	@FindBy(id="years")
	private  WebElement year;
	
	@FindBy(id="phone_mobile")
	private  WebElement phnNo;

	@FindBy(name="submitAccount")
	private  WebElement registeredAccount;

	
   public CreatePge(WebDriver driver , WebDriverUtility wp)
	{
		super(driver,wp);
	}
	public void detailForm(String firstname , String lastname , String passwrd,String value ,String value1,
			                String value2, String sname, String ename ,String addresss,String city,String value3
			                ,String code,String number)
	{
		wp.click(radioButton);
	    wp.enterKeyword(firstName, firstname);
        wp.enterKeyword(lastName, lastname);
        wp.enterKeyword(password, passwrd);
        wp.selectByTextListBox(date, value);
        wp.selectByTextListBox(months, value1);
        wp.selectByTextListBox(year, value2);
       
		wp.enterKeyword(fname,sname );
		wp.enterKeyword(lname, ename);
		wp.enterKeyword(address, addresss);
		wp.enterKeyword(cityName, city);
		wp.selectByTextListBox(statelink, value3);
		wp.enterKeyword(zonalCode, code);
		wp.enterKeyword(phnNo, number);
		wp.click(registeredAccount);
	 
		}
	
    	}
    		
    		








