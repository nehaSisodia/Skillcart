package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecommerce.generic.WebDriverUtility;

public class LoginPage extends BasePage
{
@FindBy(partialLinkText="Sign in")
 private WebElement SignInlink;

@FindBy(id="email")
private WebElement username;

@FindBy(id="passwd")
private WebElement password;

@FindBy(name="SubmitLogin")
private WebElement submitButton;

@FindBy(linkText="Forgot your password?")
private WebElement forgotAccount;

@FindBy(name="email_create")
private WebElement emailcreate;

@FindBy(xpath="//button[@name='SubmitCreate']")
private WebElement createAccount;

public HomePage hp;
public LoginPage(WebDriver driver,WebDriverUtility wp)
{
	super(driver, wp);
}

public CreatePge createAccount(String user)
{
	wp.click(SignInlink);
	wp.enterKeyword(emailcreate, user);
	wp.click(createAccount);
	return new CreatePge(driver, wp);
}
public HomePage login(String un,String pd)
{
	wp.click(SignInlink);
	wp.enterKeyword(username ,un);
	wp.enterKeyword(password,pd);
	wp.click(submitButton);
	return hp=new HomePage(driver, wp);
	}
}

