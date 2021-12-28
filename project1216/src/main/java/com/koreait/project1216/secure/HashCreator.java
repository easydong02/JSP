package com.koreait.project1216.secure;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//�Ϲ� �� �����͸� 64���� �ؽð����� ��ȯ�غ���!!
public class HashCreator {
	
	public static String getHash(String text) {
		StringBuffer sb=null;
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			
			//������ �߰� �ɰ���..
			byte[] hash=digest.digest(text.getBytes("utf-8"));
			
			//16������ ��ȯ�غ���!!
			sb = new StringBuffer();
			
			for(int i=0;i<hash.length;i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				//���ڿ��� ���̰� 1�� ��� 0�� ������!!
				if(hex.length()==1) {
					sb.append("0");
				}
				sb.append(hex);
			}
			System.out.println(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new HashCreator().getHash("apple"));
	}
	
}
