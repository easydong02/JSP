package com.koreait.project1216.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//������ SMTP ������ �̿��Ͽ�, ���ϴ� �ּҷ� ���Ϻ�����
public class MailSender {

	String host ="smtp.gmail.com"; //������ �����ϴ�  smtp���� �ּ�
	String user="easydong02@gmail.com"; //���� gmail����
	String password="wyxwreoghltepwlj"; //����: ������ ũ���� ȯ�ἳ�� ���� �����ϴ� �� ��й�ȣ..
	Properties props = new Properties();
	
	public void send(String to) {
		//������ �ۼ��� �Ӽ����� ����Ͽ� ������ ������ �����غ���!!
		//key-value�� ������ ���� ���� ��ü �� Properties�� ����غ���
		props.put("mail.smtp.host",host);
		props.put("mail.smtp.port",465);
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.ssl.enable","true");
		props.put("mail.smtp.ssl.trust","smtp.gmail.com");
		
		Session session =Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user,password);
			}
		});
		
		//������ ȹ���ߴٸ�, ���� �߼�...
		MimeMessage message = new MimeMessage(session);
		//from
		try {
			message.setFrom(new InternetAddress(user));//�������� �ּ�
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); //���� ���
			message.setSubject("ȸ������ ���� ����"); //����
			message.setContent("<h1>ȸ���� �ǽ� ���� �������� ���ϵ帳�ϴ�!<h1>","text/html;charset=utf-8"); //����
			Transport.send(message); //���� ����
			System.out.println("���� �߼� �Ϸ�");
		} catch (MessagingException e) {
			e.printStackTrace();
		} 
	}
	
}
