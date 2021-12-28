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
		bt = new JButton("결과보기");
		movieManager = new MovieManager();
		
		ch.add("매트릭스");
		ch.add("어바웃타임");
		ch.add("다크나이트");
		ch.add("건축학개론");
		
		//스타일
		setLayout(new FlowLayout());
		
		//조립
		add(ch);
		add(bt);
		
		//이벤트리스터 연결
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
