package com.koreait.project1210.swing;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/*
 *�ڹٴ� ���������� XML�� ����� ģ���� ����̹Ƿ�, �̹� javaSE���� XML�Ľ̰��� ���̺귯���� ����! 
 * XML�Ľ��� ������� 2���� ����� �ִ�.
 * 1)DOM
 *  -SAX�� ���� ���� �Ľ̹���� ����.. ������...����Ʈ���̳� �������� ����̽����� ����
 *  ���� �޸� ���ɿ� ���� �¿�ȴ�
 * 2)SAX
 * - DOM�� ���� �ڵ��ۼ��� �����ʴ�((�̺�Ʈ ���)
 * DOM�� ���� ���� ����
 * */
public class XMLApp {
	SAXParserFactory factory = SAXParserFactory.newInstance(); //�̱������� ����!!
	SAXParser saxParser;
	MyHandler handler;
	File file;
	
	public XMLApp() {
		try {
			saxParser = factory.newSAXParser();
			
			URL url =ClassLoader.getSystemResource("res/Mypet.xml");
			URI uri = url.toURI();
			
			file = new File(uri);
			saxParser.parse(file, handler =new MyHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new XMLApp();
	}
}
