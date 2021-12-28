package com.koreait.project1210.swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*
 * 웹브라우저가 아닌, 자바 일반 클래스도 웹서버에 요청을 할 수 있을까?
 * 
 * */
public class DataLoader extends JFrame{
	
	JButton bt;
	JTextArea area;
	URL url;
	URLConnection urlCon;
	HttpURLConnection httpCon; //웹서버와의 통신이 가능한 객체 get/post 메서드 지원..
	InputStreamReader reader ;//문자기반 입력스트림
	BufferedReader buffr; //문자기반의 버퍼처리된 스트림
	
	public DataLoader() {
		bt =new JButton("Load");
		area = new JTextArea();
		
		//조립
		setLayout(new java.awt.FlowLayout());
		add(bt);
		add(area);
		
		//스타일 적용
		area.setPreferredSize(new Dimension(470, 320));
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("나눌렀어?");
				requestWeb();
			}
		});
		
		//윈도우 설정
		this.setSize(500,400);
		this.setVisible(true);
	}
	
	public void requestWeb() {
		try {
			url = new URL("http://118.36.137.82:9999/map/list.jsp");//웹상의 주소
			urlCon = url.openConnection();
			httpCon = (HttpURLConnection)urlCon;
			
			//요청을 시도해보자!!
			httpCon.setRequestMethod("GET");
			
			int responseCode = httpCon.getResponseCode();//서버의 status 상태코드
			
			System.out.println("responseCode is " + responseCode);
			
			InputStream is = httpCon.getInputStream(); //바이트 기반의 입력스트림..
			reader = new InputStreamReader(is); //문자기반 스트림으로 업그레이드!! (빨대 덧씌움)
			buffr =new BufferedReader(reader);//버퍼기반 스트림으로 업그레이드
			
			//문자열 모으기!!!
			StringBuffer data=new StringBuffer();
			
			while(true) {
				String msg = buffr.readLine();//한 줄의 데이터
				if(msg==null)break;
				data.append(msg);
			}
			
			//버퍼를 이용하여 문자열 출력!!!
			System.out.println(data.toString());
			//서버로부터 String으로 전달받은 데이터는 json객체도 아니고 그냥 sTring
			//따라서 객체처럼 .찍고 접근 불가능 -- String - > convert -> Json Object
			//여러 라이브러리 중 simpleJson
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonStr= (JSONObject) jsonParser.parse(data.toString());
			
			area.append("제목 : " +jsonStr.get("title") + "\n");
			area.append("위도 : " +jsonStr.get("lati") + "\n");
			area.append("경도 : " +jsonStr.get("longi") + "\n");
			area.append("파일명 : " +jsonStr.get("filename") + "\n");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if(buffr !=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new DataLoader();
	}
}
