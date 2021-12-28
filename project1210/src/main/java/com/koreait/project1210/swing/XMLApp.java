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
 *자바는 고전적으로 XML과 상당히 친숙한 언어이므로, 이미 javaSE에는 XML파싱관련 라이브러리가 지원! 
 * XML파싱의 방법에는 2가지 방법이 있다.
 * 1)DOM
 *  -SAX에 비해 비교적 파싱방법이 쉽다.. 하지만...스마트폰이나 저성능의 디바이스에는 지양
 *  돔이 메모리 성능에 의해 좌우된다
 * 2)SAX
 * - DOM에 비해 코등작성이 쉽지않다((이벤트 방식)
 * DOM에 비해 성능 우위
 * */
public class XMLApp {
	SAXParserFactory factory = SAXParserFactory.newInstance(); //싱글턴으로 생성!!
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
