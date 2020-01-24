package com.example.demo.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMasterData {
	
	
	public static final  String EXCELFILELOCATION = "C:\\Users\\veljko.siracki\\Desktop\\Data.xlsx";
	 
	
	
	 private static FileInputStream fis;
	 private static XSSFWorkbook workbook;
	 private static XSSFSheet sheet;
	 private static XSSFRow row;
	
	
	 public static void loadExcel() throws Exception {	 
		 
		 File file = new File(EXCELFILELOCATION);
		 fis = new FileInputStream(file);
		 workbook = new XSSFWorkbook(fis);
		 sheet = workbook.getSheet("TestData");		 
		 fis.close();	 
		 
	 }
	 
	 public static List<Map<String, String>> readAllData() throws Exception {
		 
		 
		 if(sheet == null) {
			 loadExcel();
		 }
		 
		 List<Map<String, String>> mapLists = new ArrayList<Map<String,String>>();
		 
		 
		 int rows = sheet.getLastRowNum();
		 row = sheet.getRow(0);
		 
		 for(int j = 1; j<row.getLastCellNum(); j++) {
			 
			 Map<String, String> myMap = new HashMap<String, String>();
			 
			 for(int i = 1; i < rows +1; i++ ) {				 
				 Row r = CellUtil.getRow(i, sheet);
				 String key = CellUtil.getCell(r, 0).getStringCellValue(); // ovo je key iz reda
				 String value = CellUtil.getCell(r, j).getStringCellValue(); //ovo je vrednost za svaki key				 
				 myMap.put(key, value);				 
				 
			 }
			 	mapLists.add(myMap);
		 }		 
		 return mapLists;
	 }
	 
	
		

	
	 
}
