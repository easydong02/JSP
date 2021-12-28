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
 * ���������� �ƴ�, �ڹ� �Ϲ� Ŭ������ �������� ��û�� �� �� ������?
 * 
 * */
public class DataLoader extends JFrame{
	
	JButton bt;
	JTextArea area;
	URL url;
	URLConnection urlCon;
	HttpURLConnection httpCon; //���������� ����� ������ ��ü get/post �޼��� ����..
	InputStreamReader reader ;//���ڱ�� �Է½�Ʈ��
	BufferedReader buffr; //���ڱ���� ����ó���� ��Ʈ��
	
	public DataLoader() {
		bt =new JButton("Load");
		area = new JTextArea();
		
		//����
		setLayout(new java.awt.FlowLayout());
		add(bt);
		add(area);
		
		//��Ÿ�� ����
		area.setPreferredSize(new Dimension(470, 320));
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("��������?");
				requestWeb();
			}
		});
		
		//������ ����
		this.setSize(500,400);
		this.setVisible(true);
	}
	
	public void requestWeb() {
		try {
			url = new URL("http://118.36.137.82:9999/map/list.jsp");//������ �ּ�
			urlCon = url.openConnection();
			httpCon = (HttpURLConnection)urlCon;
			
			//��û�� �õ��غ���!!
			httpCon.setRequestMethod("GET");
			
			int responseCode = httpCon.getResponseCode();//������ status �����ڵ�
			
			System.out.println("responseCode is " + responseCode);
			
			InputStream is = httpCon.getInputStream(); //����Ʈ ����� �Է½�Ʈ��..
			reader = new InputStreamReader(is); //���ڱ�� ��Ʈ������ ���׷��̵�!! (���� ������)
			buffr =new BufferedReader(reader);//���۱�� ��Ʈ������ ���׷��̵�
			
			//���ڿ� ������!!!
			StringBuffer data=new StringBuffer();
			
			while(true) {
				String msg = buffr.readLine();//�� ���� ������
				if(msg==null)break;
				data.append(msg);
			}
			
			//���۸� �̿��Ͽ� ���ڿ� ���!!!
			System.out.println(data.toString());
			//�����κ��� String���� ���޹��� �����ʹ� json��ü�� �ƴϰ� �׳� sTring
			//���� ��üó�� .��� ���� �Ұ��� -- String - > convert -> Json Object
			//���� ���̺귯�� �� simpleJson
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonStr= (JSONObject) jsonParser.parse(data.toString());
			
			area.append("���� : " +jsonStr.get("title") + "\n");
			area.append("���� : " +jsonStr.get("lati") + "\n");
			area.append("�浵 : " +jsonStr.get("longi") + "\n");
			area.append("���ϸ� : " +jsonStr.get("filename") + "\n");
			
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
