package com.ecommerce.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	public static String getExcelData(String path , String sheetName,int row,int cell)
	{
		try {
		FileInputStream fis=new FileInputStream(path);
     Sheet sheet = WorkbookFactory.create(fis).getSheet(sheetName);
      return sheet.getRow(row).getCell(cell).toString();
		}
		catch(IOException e)
		{
			
		}
		return null;
     }
	public  Object [][] getExcelData1(String path , String sheetName)
	{
		Object[][] arr=null;
		try {
		FileInputStream fis=new FileInputStream(path);
     Sheet sheet = WorkbookFactory.create(fis).getSheet(sheetName);
     int row=sheet.getPhysicalNumberOfRows();
     arr=new String[row-1][];
     for(int i=0,k=0;i<=row-1;i++ ,k++)
     {
    int cell=sheet.getRow(i).getPhysicalNumberOfCells();
		for(int j=0;j<=cell-1;j++)
		{
		arr[k] [j]=sheet.getRow(i).getCell(j).toString();
		}
     }
     return arr;
     }
		catch(IOException e)
		{
			
		}
		return null;
	}
	}