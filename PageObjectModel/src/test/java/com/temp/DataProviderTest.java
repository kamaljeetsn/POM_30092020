package com.temp;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.yatra.util.Xls_Reader;

public class DataProviderTest {
	
/*	@Test(dataProvider="getData")
	public void testDP(String name,String age,String email){
		System.out.println();
		
	}
*/
	
	@Test(dataProvider="getData")
	public void testDP(Hashtable<String, String> data){
		System.out.println("Name : " + data.get("Name") + " Age : " + data.get("Age"));
		
	}
	
/*	@DataProvider
	public Object[][] getData(){
		Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data", "TestData.xlsx");
		String sheetName = "Data";
		int rows = xls.getRowCount("Data");
		int cols = xls.getColumnCount("Data");
		System.out.println("Rows Count : " + rows);
		System.out.println("Column Count : " + cols);
		Object[][] data = new Object[rows-1][cols];
		int dataRow = 0;
		for(int iRow=2;iRow<=rows;iRow++){
			for(int iCol=0;iCol<cols;iCol++){
				System.out.println("datarow : " + dataRow);
				data[dataRow][iCol] = xls.getCellData("Data", iCol, iRow);
				System.out.println(xls.getCellData("Data", iCol, iRow));
			}
			dataRow++;
		}
		
		
		return data;
		
	}
*/
	@DataProvider
	public Object[][] getData(){
		Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data", "TestData.xlsx");
		String sheetName = "Data";
		int rows = xls.getRowCount("Data");
		int cols = xls.getColumnCount("Data");
		System.out.println("Rows Count : " + rows);
		System.out.println("Column Count : " + cols);
		Object[][] data = new Object[rows-1][1];
		int dataRow = 0;
		Hashtable<String, String> table = null;
		for(int iRow=2;iRow<=rows;iRow++){
			table = new Hashtable<String, String>();
			for(int iCol=0;iCol<cols;iCol++){
				//System.out.println("datarow : " + dataRow);
				String key = xls.getCellData("Data", iCol, 1);
				String value = xls.getCellData("Data", iCol, iRow);
				table.put(key, value);
				//System.out.println(xls.getCellData("Data", iCol, iRow));
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		
		
		return data;
		
	}
	
	
	
}

