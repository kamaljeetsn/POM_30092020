package com.selenium.yatra.util;

public class XlsReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data", "TestData.xlsx");
		//xls.initExcel("D:\\Trainings\\Selenium\\WorkspaceP\\PageObjectModel\\Data", "TestData.xlsx");
		int rows = xls.getRowCount("Data");
		System.out.println(rows);
		System.out.println(xls.getColumnCount("Data"));
		for(int iRow=2;iRow<=rows;iRow++){
			String Name = xls.getCellData("Data", "Name", iRow);
			String Age = xls.getCellData("Data", "Age", iRow);
			System.out.println("Name : " + Name + " Age : " + Age);
		}
		
	}

}
