 <%
  // file="../common/include/home_ses_check.inc"

  // 세션 객체의 속성 확인
  String cust_id = (String)session.getAttribute("cust_id");
  String cust_name = (String)session.getAttribute("cust_name");
  Boolean login = false;

  if ((cust_id != null) && (cust_name != null)) {
     login = true;      // 로그인 상태
  } 
 %>