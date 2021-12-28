package com.koreait.project1210.swing;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.koreait.project1210.domain.Pet;

//�ؼ� ����� �Ǵ� �� �Ľ� ����� �Ǵ� xml�� �� ���(=node)�� ���� �� ����
//������ �̺�Ʈ�� �߻������ִ� ��ü�� �ٷ� DefaultHandler�̴�!!
public class MyHandler  extends DefaultHandler{
	ArrayList<Pet> list;
	//���±׸��� ������ �ο��ؾ� �ϹǷ�, ����ΰ� ��� ��ġ�� ���ִ����� �� �� �ִ� ������ �̿��غ���!!
	boolean isPet= false;
	boolean isName= false;
	boolean isSpecies= false;
	boolean isAge= false;
	Pet pet;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("������ ���۵Ǿ����!!");
		list = new ArrayList<Pet>();
	}
	
	@Override
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.print("<"+tag+">");
		
		//������ ������������, �ݷ����� �Ѹ��� �����ϴ� �±׸� ������ ����..
		if(tag.equals("pet")) {
			pet = new Pet();
		}
		if(tag.equals("name")) {
			isName=true;
		}
		if(tag.equals("type")) {
			isSpecies=true;
		}
		if(tag.equals("age")) {
			isAge=true;
		}
	}
	
	@Override
	//�±� ������ ���ڿ� ��带 �߰����� ��
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);
		System.out.print(data);
		
		if(isName) {
			pet.setName(data);
		}
		if(isSpecies) {
			pet.setSpecies(data);
		}
		if(isAge) {
			pet.setAge(Integer.parseInt(data));
		}
		
		
	}
	
	@Override
	public void endElement(String uri, String localName, String tag) throws SAXException {
		
		System.out.println("</"+tag+">");
		
		if(tag.equals("pet")) {
			list.add(pet);
		}
		if(tag.equals("name")) {
			isName=false;
		}
		if(tag.equals("type")) {
			isSpecies=false;
		}
		if(tag.equals("age")) {
			isAge=false;
		}
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("������ ���� �����߾��! �� ����� �ݷ����� ���� " + list.size());
		
		for( Pet obj : list) {
			System.out.println(obj.getName()+", "+obj.getSpecies()+", "+obj.getAge());
		}
	}
	
	
}
