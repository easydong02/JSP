package com.koreait.mvc.view.blood;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.koreait.mvc.model.blood.BloodManager;

public class BloodForm extends JFrame {
	Choice ch;
	JButton bt;
	BloodManager bloodManager;
	
	public BloodForm() {
		ch = new Choice();
		bt = new JButton("결과보기");
		bloodManager = new BloodManager();
		
		ch.add("a");
		ch.add("b");
		ch.add("ab");
		ch.add("o");
		
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
		String msg  =bloodManager.getAdvice(ch.getSelectedItem());
		JOptionPane.showMessageDialog(this, msg);
	}
	
	
	public static void main(String[] args) {
		new BloodForm();
	}
}
