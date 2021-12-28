package com.koreait.project1216.secure;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//일반 평문 데이터를 64자의 해시값으로 반환해보자!!
public class HashCreator {
	
	public static String getHash(String text) {
		StringBuffer sb=null;
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			
			//원문을 잘게 쪼갠다..
			byte[] hash=digest.digest(text.getBytes("utf-8"));
			
			//16진수로 변환해보자!!
			sb = new StringBuffer();
			
			for(int i=0;i<hash.length;i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				//문자열의 길이가 1인 경우 0을 붙이자!!
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
