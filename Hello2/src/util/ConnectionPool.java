package util;


import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class ConnectionPool {

	
	private static DataSource _ds=null; //DataSource 타입의 변수 _ds를 null로 초기화 static으로 선언되어 
	
	public static Connection get() throws NamingException,SQLException{ //get함수 _ds변수가 클래스 변수 공용변수로 선언을 하여 get()도 static으로 정의된다.
		if(_ds==null) { //null일 경우 datasource 객체를 가져와서 _ds 저장한다.
			_ds=(DataSource)(new InitialContext()).lookup("java:comp/env/jdbc/mysns");
		}
		return _ds.getConnection(); //연결 객체를 반환
	}
	
	
	
}
