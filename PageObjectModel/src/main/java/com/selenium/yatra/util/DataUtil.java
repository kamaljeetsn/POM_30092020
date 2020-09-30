package com.selenium.yatra.util;

import java.util.Hashtable;

public class DataUtil {
	
	public static Object[][] getData(Xls_Reader xls,String testCaseName){
		
		String sheetName = testCaseName;
		int rows = xls.getRowCount(sheetName);
		int cols = xls.getColumnCount(sheetName);
		System.out.println("Rows Count : " + rows);
		System.out.println("Column Count : " + cols);
		Object[][] data = new Object[rows-1][1];
		int dataRow = 0;
		Hashtable<String, String> table = null;
		for(int iRow=2;iRow<=rows;iRow++){
			table = new Hashtable<String, String>();
			for(int iCol=0;iCol<cols;iCol++){
				//System.out.println("datarow : " + dataRow);
				String key = xls.getCellData(sheetName, iCol, 1);
				String value = xls.getCellData(sheetName, iCol, iRow);
				table.put(key, value);
				//System.out.println(xls.getCellData("Data", iCol, iRow));
			}
			data[dataRow][0] = table;
			dataRow++;
		}
			return data;
	}

	public static boolean isTestExecutable(Xls_Reader xls,String testCaseName){
		String sheetName = "TestCaseExecutor";
		int rows = xls.getRowCount(sheetName);
		int cols = xls.getColumnCount(sheetName);
		System.out.println("Rows Count : " + rows);
		System.out.println("Column Count : " + cols);
		for(int iRow=2;iRow<=rows;iRow++){
			String testcase = xls.getCellData(sheetName, "TestCaseName", iRow);
			if(testCaseName.equals(testcase)){
				String runMode = xls.getCellData(sheetName, "RunMode", iRow);
				if(runMode.equals("Y")){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
}


