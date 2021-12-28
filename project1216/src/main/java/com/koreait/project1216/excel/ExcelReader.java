package com.koreait.project1216.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {
	FileInputStream fis;
	
	public ExcelReader() {
		//파일의 경로를 클래스패스로부터 구하자!!
		try {
			URL url = ClassLoader.getSystemResource("com/koreait/project1216/excel/data2.xls");
			URI uri = url.toURI();
			File file = new File(uri);
			fis = new FileInputStream(file);
			HSSFWorkbook workbook =new HSSFWorkbook(fis); //엑셀파일 접근
			HSSFSheet sheet = workbook.getSheetAt(0); //첫번째 시트 접근!!
			int totalRecord = sheet.getLastRowNum();
			HSSFRow row =null;
			for(int i =0; i<=totalRecord; i ++) {
			row = sheet.getRow(i);
			Iterator it = row.iterator();
			//cell.getNumericCellValue(); 숫자형 데이터 접근
			//cell.getStringCellValue(); 문자형 데이터 접근
			
				while(it.hasNext()) {
					HSSFCell cell = (HSSFCell)it.next(); //rs처럼 호출시 마다 전진하면서 다음 요소를 접근하여 오브젝트 추출
					
					if(cell.getCellType() == CellType.STRING){
						System.out.print(cell.getStringCellValue() + "\t"); 
					}else if ( cell.getCellType() == CellType.NUMERIC) {
						System.out.print(cell.getNumericCellValue() + "\t"); 
						
					}
				}
				System.out.print("\n");
			}
			

			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis !=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//엑셀파일을 제어하는 객체
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		HSSFSheet sheet;
		Row row;
	}
	
	public static void main(String[] args) {
		new ExcelReader();
	}

}
