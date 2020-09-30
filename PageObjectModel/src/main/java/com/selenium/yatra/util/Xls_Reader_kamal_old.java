package com.selenium.yatra.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader_kamal_old {
	Workbook workbook = null;
	Sheet sheet= null;
	Row row = null;
	Cell cell = null;
	
	public Xls_Reader_kamal_old(String filePath,String fileName){
		
		try{
			//Create an object of File class to open xlsx file
		    File file =    new File(filePath+"\\"+fileName);
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    //Find the file extension by splitting file name in substring  and getting only extension name
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		    System.out.println(fileExtensionName);
		  //Check condition if the file is xlsx file
		    if(fileExtensionName.equals(".xlsx")){
		    	//If it is xlsx file then create object of XSSFWorkbook class
		    	workbook = new XSSFWorkbook(inputStream);
		    }else if(fileExtensionName.equals(".xls")){
		    	//If it is xls file then create object of HSSFWorkbook class
		    	workbook = new HSSFWorkbook(inputStream);
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}

		
	}
	
/*	public void initExcel(String filePath,String fileName){
		try{
			//Create an object of File class to open xlsx file
		    File file =    new File(filePath+"\\"+fileName);
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    //Find the file extension by splitting file name in substring  and getting only extension name
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		    System.out.println(fileExtensionName);
		  //Check condition if the file is xlsx file
		    if(fileExtensionName.equals(".xlsx")){
		    	//If it is xlsx file then create object of XSSFWorkbook class
		    	workbook = new XSSFWorkbook(inputStream);
		    }else if(fileExtensionName.equals(".xls")){
		    	//If it is xls file then create object of HSSFWorkbook class
		    	workbook = new HSSFWorkbook(inputStream);
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
*/	
	public int getRowCount(String sheetName){
		sheet = workbook.getSheet(sheetName);
		//Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
		return rowCount;
	}
	
	// returns the data from a cell
/*		public String getCellData(String sheetName,String colName,int rowNum){
			try{
				if(rowNum <=0)
					return "";
			
			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";
			
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
			if(col_Num==-1)
				return "";
			
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(col_Num);
			
			if(cell==null)
				return "";
			//System.out.println(cell.getCellType());
			if(cell.getCellType()==CellType.STRING)
				  return cell.getStringCellValue();
			else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){
				  
				  String cellText  = String.valueOf(cell.getNumericCellValue());
				  if (DateUtil.isCellDateFormatted(cell)) {
			           // format in form of M/D/YY
					  double d = cell.getNumericCellValue();

					  Calendar cal =Calendar.getInstance();
					  cal.setTime(DateUtil.getJavaDate(d));
			            cellText =
			             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
			           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
			                      cal.get(Calendar.MONTH)+1 + "/" + 
			                      cellText;
			           
			           //System.out.println(cellText);

			         }
				  return cellText;
			  }else if(cell.getCellType()==CellType.BLANK)
			      return ""; 
			  else 
				  return String.valueOf(cell.getBooleanCellValue());
			
			}
			catch(Exception e){
				
				e.printStackTrace();
				return "row "+rowNum+" or column "+colName +" does not exist in xls";
			}
		}
*/
		// returns the data from a cell
		public String getCellData(String sheetName,String colName,int rowNum){
			try{
				if(rowNum <=0)
					return "";
			
			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";
			
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
			if(col_Num==-1)
				return "";
			
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(col_Num);
			DataFormatter df = new DataFormatter();
			String value = df.formatCellValue(cell);
			return value;
				}
			catch(Exception e){
				
				e.printStackTrace();
				return "row "+rowNum+" or column "+colName +" does not exist in xls";
			}
		}

}


