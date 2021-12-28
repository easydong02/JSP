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
		bt = new JButton("�������");
		bloodManager = new BloodManager();
		
		ch.add("a");
		ch.add("b");
		ch.add("ab");
		ch.add("o");
		
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
		String msg  =bloodManager.getAdvice(ch.getSelectedItem());
		JOptionPane.showMessageDialog(this, msg);
	}
	
	
	public static void main(String[] args) {
		new BloodForm();
	}
}
