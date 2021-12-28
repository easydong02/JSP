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

//구글의 SMTP 서버를 이용하여, 원하는 주소로 메일보내기
public class MailSender {

	String host ="smtp.gmail.com"; //구글이 제공하는  smtp서버 주소
	String user="easydong02@gmail.com"; //나의 gmail계정
	String password="wyxwreoghltepwlj"; //주의: 구글의 크롬의 환결설정 들어가서 생성하는 앱 비밀번호..
	Properties props = new Properties();
	
	public void send(String to) {
		//위에서 작성한 속성들을 사용하여 메일의 정보를 세팅해보자!!
		//key-value를 구현한 맵의 하위 객체 중 Properties를 사용해본다
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
		
		//권한을 획득했다면, 메일 발송...
		MimeMessage message = new MimeMessage(session);
		//from
		try {
			message.setFrom(new InternetAddress(user));//보내는자 주소
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); //받을 사람
			message.setSubject("회원가입 축하 메일"); //제목
			message.setContent("<h1>회원이 되신 것을 진심으로 축하드립니다!<h1>","text/html;charset=utf-8"); //내용
			Transport.send(message); //메일 전송
			System.out.println("메일 발송 완료");
		} catch (MessagingException e) {
			e.printStackTrace();
		} 
	}
	
}
