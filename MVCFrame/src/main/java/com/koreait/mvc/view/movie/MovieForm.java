package com.koreait.mvc.view.movie;

import java.awt.*;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.koreait.mvc.model.blood.BloodManager;
import com.koreait.mvc.model.movie.MovieManager;
import com.koreait.mvc.view.blood.BloodForm;

public class MovieForm  extends JFrame{
	Choice ch;
	JButton bt;
	MovieManager movieManager;
	
	public MovieForm() {
		ch = new Choice();
		bt = new JButton("�������");
		movieManager = new MovieManager();
		
		ch.add("��Ʈ����");
		ch.add("��ٿ�Ÿ��");
		ch.add("��ũ����Ʈ");
		ch.add("�����а���");
		
		//��Ÿ��
		setLayout(new FlowLayout());
		
		//����
		add(ch);
		add(bt);
		
		//�̺�Ʈ������ ����
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getResult();
			}
		});
		
		setSize(300,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void getResult() {
		String msg  =movieManager.getMsg(ch.getSelectedItem());
		JOptionPane.showMessageDialog(this, msg);
	}
	
	
	public static void main(String[] args) {
		new MovieForm();
	}
}
