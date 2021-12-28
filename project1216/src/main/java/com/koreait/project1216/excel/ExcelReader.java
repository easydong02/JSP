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
		//������ ��θ� Ŭ�����н��κ��� ������!!
		try {
			URL url = ClassLoader.getSystemResource("com/koreait/project1216/excel/data2.xls");
			URI uri = url.toURI();
			File file = new File(uri);
			fis = new FileInputStream(file);
			HSSFWorkbook workbook =new HSSFWorkbook(fis); //�������� ����
			HSSFSheet sheet = workbook.getSheetAt(0); //ù��° ��Ʈ ����!!
			int totalRecord = sheet.getLastRowNum();
			HSSFRow row =null;
			for(int i =0; i<=totalRecord; i ++) {
			row = sheet.getRow(i);
			Iterator it = row.iterator();
			//cell.getNumericCellValue(); ������ ������ ����
			//cell.getStringCellValue(); ������ ������ ����
			
				while(it.hasNext()) {
					HSSFCell cell = (HSSFCell)it.next(); //rsó�� ȣ��� ���� �����ϸ鼭 ���� ��Ҹ� �����Ͽ� ������Ʈ ����
					
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
		
		//���������� �����ϴ� ��ü
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		HSSFSheet sheet;
		Row row;
	}
	
	public static void main(String[] args) {
		new ExcelReader();
	}

}
