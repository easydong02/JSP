package com.koreait.NoticeApp.notice.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.koreait.project1207.domain.Notice;
import com.koreait.project1207.notice.model.NoticeDAO;

import java.awt.*;
import java.awt.event.*;

/*
 * notice에 대한 게시물 등록을 하기 위한 디자인 폼
 * javaSE 기반으로 제작
 * */


public class RegistForm  extends JFrame implements ActionListener{
	JTextField t_writer;
	JTextField t_title;
	JTextArea area;
	JButton bt;
	NoticeDAO noticeDAO;
	//디자인 초기화
	public RegistForm() {
		//생성 및 조립
		t_writer = new JTextField(20);
		t_title = new JTextField(20);
		area = new JTextArea(10,25);
		bt = new JButton("글등록");
		noticeDAO = new NoticeDAO();
		
		this.setLayout(new java.awt.FlowLayout());
		
		add(t_title);
		add(t_writer);
		add(area);
		add(bt);
		
		//버튼에 리스너 연결
		bt.addActionListener(this);
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//윈도우창을 닫으면 프로세스 종료
	}
	
	public void actionPerformed(ActionEvent e) {
		//데이터 베이스에 넣기!!
		
		Notice notice = new Notice();
		notice.setWriter(t_writer.getText());
		notice.setTitle(t_title.getText());
		notice.setContent(area.getText());
		
		int result = noticeDAO.insert(notice); //db 등록
		if(result !=0) {
			JOptionPane.showMessageDialog(this,"등록성공");
		}else {
			
			JOptionPane.showMessageDialog(this,"등록실패");
		}
	}
	
	public static void main(String[] args) {
		new RegistForm();
	}
	
}
