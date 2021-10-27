<%--  // file = "../../common/include/jsp_sql_dbset_iu.inc"
      // 전송 데이터 변수 할당 --%>
<%
  String cust_pw = request.getParameter("cust_pw");
  String cust_name = request.getParameter("cust_name"); 

  // 전화번호 처리
  String tel_no_gubun = request.getParameter("tel_no_gubun");
  String tel_no_guk = request.getParameter("tel_no_guk");
  String tel_no_seq = request.getParameter("tel_no_seq");
  String cust_tel_no = tel_no_gubun + "-"
                     + tel_no_guk + "-" + tel_no_seq;

  String cust_addr = request.getParameter("cust_addr");
  String cust_gender = request.getParameter("cust_gender"); // null

  // 이메일 처리
  String cust_email;
  String cust_email_1 = request.getParameter("cust_email_1");
  String cust_email_2 = request.getParameter("cust_email_2");

  if ((cust_email_1.length() == 0) && (cust_email_2.length() == 0)) {
      cust_email = "";                                      // empty
  } else {
	  cust_email = cust_email_1 + "@" + cust_email_2;
  }
%>