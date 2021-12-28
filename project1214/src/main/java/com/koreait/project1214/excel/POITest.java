package com.koreait.project1214.excel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//����ũ�μ���Ʈ ��ǰ�� ������ �� �ִ� ���� ���̺귯���� ����ġ�� POI�� �̿��غ���!
public class POITest {
	
	public POITest() {
		URL url = ClassLoader.getSystemResource("com/koreait/project1214/excel/data.xlsx");
				
		try {
			File file=new File(url.toURI());
			XSSFWorkbook workbook = new XSSFWorkbook(file) ; //��������
			System.out.println("���� ���� ����!");
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new POITest();
	}

}
