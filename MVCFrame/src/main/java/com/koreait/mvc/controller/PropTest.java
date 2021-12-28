package com.koreait.mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropTest {
	FileInputStream fis;
	Properties props;
	
		
	
	public PropTest() {
		try {
			fis = new FileInputStream("D:\\bigData\\jsp_workspace\\MVCFrame\\src\\main\\webapp\\WEB-INF\\memo.babo");
			props=new Properties();
			props.load(fis); //스트림 탑재
			System.out.println(props);
			
			String value = props.getProperty("/blood.do");
			System.out.println(value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new PropTest();

	}

}
