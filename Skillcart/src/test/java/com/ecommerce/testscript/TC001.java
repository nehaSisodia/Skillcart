package com.ecommerce.testscript;


import org.testng.annotations.Test;

import com.ecommerce.generic.ExcelLibrary;
import com.ecommerce.generic.Utility;
import com.ecommerce.pages.CatagoryPage;
import com.ecommerce.pages.orderPage;
import com.ecommerce.pages.productPage;

public class TC001 extends Basetest2
{
	@Test(description="test for item deleting")
  public void addItem()
  {
        // HomePage hp=new HomePage(driver, wp);
		String path="./resorces/testcase1.xlsx";
		String sheet="TC002";
		
		String Menu= ExcelLibrary.getExcelData(path, sheet, 1, 0);
		String Product_Id= Utility.getIntText(ExcelLibrary.getExcelData(path, sheet, 1, 1));
		String Color= ExcelLibrary.getExcelData(path, sheet, 1, 2);
		String Size=ExcelLibrary.getExcelData(path, sheet, 1, 3);
		int quant= Utility.returnInteger(ExcelLibrary.getExcelData(path, sheet, 1, 4));
		
         CatagoryPage cp = hp.menuList(Menu);
		 productPage pdp = cp.selectItem(Product_Id);
		 
		 pdp.selectSize(Size);
		 pdp.selectColor(Color);
		 pdp.increaseQuntity(quant);
		 pdp.addToCartIn();
	  orderPage odp = pdp.proceedFurther();
	  odp.isProductDisplayed(Product_Id);
	  odp.deletItem(Product_Id);
	  
		
		
}
}