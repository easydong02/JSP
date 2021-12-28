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
 * notice�� ���� �Խù� ����� �ϱ� ���� ������ ��
 * javaSE ������� ����
 * */


public class RegistForm  extends JFrame implements ActionListener{
	JTextField t_writer;
	JTextField t_title;
	JTextArea area;
	JButton bt;
	NoticeDAO noticeDAO;
	//������ �ʱ�ȭ
	public RegistForm() {
		//���� �� ����
		t_writer = new JTextField(20);
		t_title = new JTextField(20);
		area = new JTextArea(10,25);
		bt = new JButton("�۵��");
		noticeDAO = new NoticeDAO();
		
		this.setLayout(new java.awt.FlowLayout());
		
		add(t_title);
		add(t_writer);
		add(area);
		add(bt);
		
		//��ư�� ������ ����
		bt.addActionListener(this);
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//������â�� ������ ���μ��� ����
	}
	
	public void actionPerformed(ActionEvent e) {
		//������ ���̽��� �ֱ�!!
		
		Notice notice = new Notice();
		notice.setWriter(t_writer.getText());
		notice.setTitle(t_title.getText());
		notice.setContent(area.getText());
		
		int result = noticeDAO.insert(notice); //db ���
		if(result !=0) {
			JOptionPane.showMessageDialog(this,"��ϼ���");
		}else {
			
			JOptionPane.showMessageDialog(this,"��Ͻ���");
		}
	}
	
	public static void main(String[] args) {
		new RegistForm();
	}
	
}
