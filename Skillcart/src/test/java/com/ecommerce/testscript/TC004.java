package com.ecommerce.testscript;

import org.testng.annotations.Test;

import com.ecommerce.pages.CreatePge;

public class TC004 extends BaseTest
{

	@Test(description="test for CREATE  new account")
  public void createAnAccount() {
	String path="./resorces/testcase1.xlsx";
	String sheet="TC002";
	
	CreatePge cp=new CreatePge(driver, wp);
	cp.detailForm("neha", "sisodia", "neha@123","14","12","1992","neha",
			"sisodia","Alaska","Alaska","Alaska","00100","0087879080");
	
	
	
	}
	
}
