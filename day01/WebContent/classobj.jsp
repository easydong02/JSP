<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
class Account {
	String account_no = "";
	int balance =0;
	
	Account(String account_no){//생성자 1.클래스명과 동일  2. 리턴타입 없다.
		this.account_no = account_no;
	}
	
	int deposit(int amount){
		balance += amount;
		return balance;
	}
	
	int payment(int amount){
		if(balance>=amount){
			return balance -=amount;
		}
		else{
			return balance;
		}
	}

	
}

%>

<%
int deposit_don =0;
int payment_don =0;
int balance =0;

Account account = new Account("1002-851-332901");
account.deposit(100000000);
out.print("계좌번호: "+account.account_no +"<br>");
out.print("잔액: "+account.balance +"<br>");

Account account2 = new Account("1002-998-332902");
deposit_don=5000;
account2.deposit(deposit_don);
out.print("계좌번호: "+account2.account_no +"<br>");
out.print("잔액: "+account2.balance +"<br>");


%>
</body>
</html>