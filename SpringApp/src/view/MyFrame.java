package view;

import javax.swing.JComponent;
import javax.swing.JFrame;

//���� ������ �Դ� javaSE�� ������ ���α׷���(Swing,AWT)��
//������ ������� �����غ���!!
public class MyFrame  extends JFrame{
	private JComponent t_id;
	private JComponent t_pass;
	private JComponent bt;
	
//	public void setT_id(JComponent t_id) {
//		this.t_id = t_id;
//	}
//
//	public void setT_pass(JComponent t_pass) {
//		this.t_pass = t_pass;
//	}
//
//	public void setBt(JComponent bt) {
//		this.bt = bt;
//	}

	public MyFrame(JComponent t_id, JComponent t_pass, JComponent bt) {
		this.t_id=t_id;
		this.t_pass=t_pass;
		this.bt=bt;
		//����
		this.setLayout(new java.awt.FlowLayout());
		t_id.setPreferredSize(new java.awt.Dimension(250,45));
		t_pass.setPreferredSize(new java.awt.Dimension(250,45));
		add(t_id);
		add(t_pass);
		add(bt);
		
		
		//����
		this.setVisible(true);
		this.setSize(300,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
