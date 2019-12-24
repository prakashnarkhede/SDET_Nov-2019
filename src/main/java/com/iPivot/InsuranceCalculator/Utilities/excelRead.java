package com.iPivot.InsuranceCalculator.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {
	
	public Object[][] ExcelDataInObjectArray() throws Exception {
		
		//where is my xl file ???
		String filePath = System.getProperty("user.dir")+"/src/test/resources/ExcelTestData/VehicleInsuranceCalcualator_TestData.xlsx";
		
		//working file
		File xlFIle = new File(filePath);
		
		//fileInputStream
		FileInputStream fis = new FileInputStream(xlFIle);
		
		//start reading excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("InsurancePremium");
			
		//find total number of rows in excel sheet
		int totalRows = sheet.getLastRowNum()+1;
		int totalCols = sheet.getRow(0).getLastCellNum();
		
		//object array to store map
		Object [][] vehData = new Object[totalRows-1][1];		
		Map<String, String> dataMap = new HashMap<String, String>();
	
		for(int i = 1; i<totalRows; i++) {
			Map<String, String> tempMap = new HashMap<String, String>();

			for(int j = 0; j <totalCols; j++) {
				sheet.getRow(i).getCell(j).setCellType(CellType.STRING);			
		        dataMap.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());		
			}
			
			tempMap.putAll(dataMap);
			vehData[i-1][0] = tempMap;
		}
		return vehData;

	}

	public Map getMapDataFromRow(int rowNum) {
		Map<String, String> mapData = new HashMap<String, String>();
		//add data from row = rowNum to map and then return it
		
		return mapData;
	}


}
