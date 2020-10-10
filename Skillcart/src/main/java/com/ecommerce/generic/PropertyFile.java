package com.ecommerce.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
    
	public  static String getDataFromProperty(String key)
	{   String data="";
		try {
		FileInputStream fis=new FileInputStream("F:\\New folder\\EcommerceApp\\Resorcefile\\config4.properties");
	     Properties p=new Properties();
	     p.load(fis);
	data= p.getProperty(key);
		}
		catch(Exception e)
		{
			System.out.println("file not found");
		}
		return data;
	}
}
