package com.ecommerce.testscript;

import org.testng.annotations.Test;

import com.ecommerce.generic.Utility;
import com.ecommerce.pages.CatagoryPage;
import com.ecommerce.pages.orderPage;
import com.ecommerce.pages.productPage;

public class TC003 extends Basetest2 {
	

	@Test(description="Test selected item is there in cart")
	  public void toDeletItem()
	  {
			CatagoryPage cp = hp.menuList("DRESSES");
			 productPage pdp = cp.selectItem("4");
			int quant=Utility.returnInteger("3");
			 System.out.println(quant);
			 pdp.increaseQuntity(quant);
			 pdp.selectSize("L");
			 pdp.selectColor("Blue");
			 pdp.addToCartIn();
		  orderPage odp = pdp.proceedFurther();
		  odp.isProductDisplayed("4");
	  }
}
