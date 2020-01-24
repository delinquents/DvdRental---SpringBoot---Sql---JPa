package com.example.demo.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	
	public static final  String EXCELFILELOCATION = "./Data.xlsx";
	
	
	 private static FileInputStream fis;
	 private static XSSFWorkbook workbook;
	 private static XSSFSheet sheet;
	 private static XSSFRow row;
	
	
	 
	 public static void loadExcel() throws Exception {
		 
		 System.out.println("Loading Excel data...");
		 
		 File file = new File(EXCELFILELOCATION);
		 
		 fis = new FileInputStream(file);
		 workbook = new XSSFWorkbook(fis);
		 sheet = workbook.getSheet("TestData");		 
		 fis.close();				 
		 
	 }
	 
	 
	 
	 public static Map<String, Map<String,String>> getDataMap() throws Exception {
		 
		 
		 if(sheet == null) {
			 loadExcel();
		 }
		 
		 Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
		 Map<String, String> mayMap = new HashMap<String, String>();
		 
		 for(int i = 1; i <sheet.getLastRowNum() + 1; i++ ) {
			 
			 row = sheet.getRow(i);
			 String keyCell = row.getCell(0).getStringCellValue();
			 
			 int colNum = row.getLastCellNum();
			 for( int j =0; j < colNum ; j++) {		
				 System.out.println(j);
				 String value = row.getCell(1).getStringCellValue();
				 mayMap.put(keyCell, value);
				 
			 }
			 
			 superMap.put("MASTERDATA", mayMap);
		 }
		 
		 
		 
		 return superMap;
	 }
	
	public static String getValue(String key) throws Exception {
		
		Map<String, String> myVal = getDataMap().get("MASTERDATA");		
		String retValue = myVal.get(key);
		return retValue;
		
	}
	
//	
//	public static void main(String[] args) throws Exception {
////		System.out.print(getValue("firstName") + " ");
////		System.out.print(getValue("lastName") + " ");
////		System.out.println(getValue("address") + ".");
////		System.out.println(getValue("firstName"));
//		System.out.print(getDataMap());
//	}
//	
	
}
