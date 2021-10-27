<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%@ page import="java.lang.Math.*"%>
<%@ page import="java.text.DecimalFormat"%>

<%@ page import="dbconnclose.*"%>

<!DOCTYPE html>
<html>
<head>
<title>고객정보 테이블 검색과 페이지 제어(customer_retrieval_table_paging.jsp)</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../common/CSS/table_retrieval.css">
</head>

<body>
<%
   //상수와 변수 선언
//*********************************************************************
   int LINE_PER_PAGE = 4;              // 페이지 당 출력 줄 수
   int PAGE_PER_BLOCK = 3;             // 블럭 당 페이지 수
 //*********************************************************************
   int nbr_of_row = 0;                 // 총 회원 수
   int nbr_of_page = 0;                // 총 페이지 수
   
   int start_pointer = 0;              // DB 검색 시작 위치
   int cur_page_no = 0;                // 현재 페이지 번호
   int block_nbr = 0;                  // 블럭 번호
   int block_startpage_no = 0;         // 블럭의 시작 페이지 번호
   int block_endpage_no = 0;           // 블럭의 끝 페이지 번호
   int previous_block_start_pageno = 0;// 이전 블럭의 시작 페이지 번호
   int next_block_start_pageno = 0;    // 다음 블럭의 시작 페이지 번호
   
   // 객체참조변수 선언
   Connection conn = null;
   PreparedStatement pstmt = null;
   Statement stmt = null;
   ResultSet rset = null;   

   // JDBC 드라이버 로딩(loading JDBC driver) &
   // MariaDB 서버와 데이터베이스 연결(connect server & database )
   conn = DbConnClose.getConnection();
   
  try {
     // SQL 질의어 처리(Perform SQL query(DML))
     // 고객테이블(customer) 전체  회원 수 검색 - count(*)
     String sql = "SELECT count(*) FROM customer";
     stmt = conn.createStatement();          
     rset = stmt.executeQuery(sql);

//*********************************************************************
     // 총 회원 수 계산
     rset.next();
     nbr_of_row = Integer.parseInt(rset.getString("count(*)"));
     
     // 총 페이지 수 계산 - ceil(올림), floor(버림), round(반올림)
     nbr_of_page = (int)Math.ceil((float)nbr_of_row / LINE_PER_PAGE);

     // 검색 페이지 확인
     if (request.getParameter("pageno") == null) {
        // 맨 처음 검색
        cur_page_no = 1;
     } else if (nbr_of_page < Integer.parseInt(request.getParameter("pageno"))) {
               // DB검색 시작위치 계산
               cur_page_no = nbr_of_page;
            } else {
                  // 특정 페이지 검색 
                  cur_page_no = Integer.parseInt(request.getParameter("pageno"));    	 
     }

     // DB 검색 시작 위치와 갯수
     start_pointer = (cur_page_no - 1) * LINE_PER_PAGE;
//*********************************************************************

     //SQL 질의어 처리(perform SQL query(DML))
     // 고객테이블(customer) 튜플 검색 - prepareStatement(sql)
     sql = "SELECT * FROM customer ORDER BY cust_id ASC LIMIT ?, ?";    
     pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, start_pointer);
        pstmt.setInt(2, LINE_PER_PAGE);
     rset = pstmt.executeQuery();

     // 질의처리 결과(rset) 체크
     // cursor - 초기 상태 아니거나 행(결과)이 없으면 false 리턴
     if (!rset.isBeforeFirst()) {
        out.print("<script>alert('고객테이블(customer)이 비어 있습니다!!');"
                        + "history.back();"
                + "</script>");
     }

  // 회원 검색정보 출력     
 %> 
      
<form name="customer_form_table">
 <table>
  <caption>고객정보 테이블 검색과 페이지 제어</caption>
  <tr style="border-style:hidden hidden solid hidden;">
   <td colspan="8" style="background-color:white; text-align:right; color:blue;">
      현재 회원 수 <%=new DecimalFormat("#,###").format(nbr_of_row)%> 명&nbsp;
     (전체 <%=nbr_of_page%> 쪽 중&nbsp;현재 <%=cur_page_no%> 쪽)</td>
  </tr>
  <tr>
   <th>아이디</th>
   <th>비밀번호</th>
   <th>이름</th>
   <th>전화번호</th>
   <th>주소</th>
   <th>성별</th>
   <th>이메일</th>
   <th>가입일</th>
  </tr>
      
 <%
  // 고객정보(레코드 셋) 출력
  while (rset.next()) {

     String cust_id = rset.getString("cust_id");
     String cust_pw = rset.getString("cust_pw");
     String cust_name = rset.getString("cust_name");
     String cust_tel_no = rset.getString("cust_tel_no");
     String cust_addr = rset.getString("cust_addr");
     String cust_gender = rset.getString("cust_gender");
     if (cust_gender == null) {
        cust_gender = "";
     } else if (cust_gender.equals("M")) {
               cust_gender = "남자(" + cust_gender + ")";
            } else {
           	      cust_gender = "여자(" + cust_gender + ")";
     }         
     String cust_email = rset.getString("cust_email");
     String cust_join_date = rset.getString("cust_join_date");
%>
  <tr>
   <td><%=cust_id%></td>
   <td><%=cust_pw%></td>
   <td><%=cust_name%></td>
   <td><%=cust_tel_no%></td>
   <td><%=cust_addr%></td>
   <td><%=cust_gender%></td>
   <td><%=cust_email%></td>
   <td><%=cust_join_date%></td>
  </tr>
<%
  }
%>
  <tr>
   <td colspan="8" style="text-align:center;">  
 <%   
  //*********************************************************************
  // 페이지 리스트 제어
  block_nbr = ((cur_page_no - 1) / PAGE_PER_BLOCK) + 1;        // 블럭 번호
  block_startpage_no = ((block_nbr - 1) * PAGE_PER_BLOCK) + 1; // 블럭의 시작 페이지 번호
  block_endpage_no = (block_startpage_no + PAGE_PER_BLOCK) - 1;// 블럭의 끝 페이지 번호

  if (block_nbr > 1) {
     out.print("&nbsp[<a href='./customer_retrieval_table_paging.jsp?pageno=1'>맨 처음</a>]&nbsp");
     previous_block_start_pageno = block_startpage_no - PAGE_PER_BLOCK; // 이전 블럭의 시작페이지 결정
     out.print("&nbsp[<a href='./customer_retrieval_table_paging.jsp?pageno="
              + previous_block_start_pageno + "'>이전</a>]&nbsp");
  }

  for (int pgn = block_startpage_no; pgn <= block_endpage_no; pgn++) {

     if (pgn > nbr_of_page) {
        break;
     }

     if (pgn == cur_page_no) {
        out.print("&nbsp" + pgn + "&nbsp");
     } else {
        out.print("&nbsp[" + "<a href='./customer_retrieval_table_paging.jsp?"
        		           + "pageno=" + pgn + "'>" + pgn + "</a>]&nbsp");
     }
  }

  if (block_endpage_no < nbr_of_page) {
     next_block_start_pageno = block_endpage_no + 1;           // 다음 블럭의 시작페이지 결정
     out.print("&nbsp[<a href='./customer_retrieval_table_paging.jsp?pageno=" 
              + next_block_start_pageno + "'>다음</a>]&nbsp");
     out.print("&nbsp[<a href='./customer_retrieval_table_paging.jsp?pageno="
      		  + nbr_of_page + "'>맨 끝</a>]&nbsp");
  }
//*********************************************************************
 %>
   </td>
  </tr>
 <%

  } catch (SQLException sqlerr) {
     System.out.println("SQL 질의처리 오류!" + sqlerr.getMessage());

  } finally {
     // 데이터베이스 연결 종료(close database)
     DbConnClose.resourceClose(rset, pstmt, conn);  
  }
 %> 
 </table>
</form>

   <a href="./customer_maintenance.jsp">[ 고객정보관리 ]</a>

</body>
</html>