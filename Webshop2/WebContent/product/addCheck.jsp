<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="java.util.*"%>
<%@ page import="util.*"%>
<%@ page import="java.io.File"%>
<%@page import="dao.ProductObj"%>
<%@page import="dao.ProductDAO"%>

<%
	String pid = null, pname = null, pdescription = null, pprice = null, pfname = null;
byte[] pfile = null;

request.setCharacterEncoding("utf-8");

ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
//추출된 값들을 FileItem 객체의 형태로 저장하기 위해서 준비

List items = sfu.parseRequest(request);
//parseRequest() 함수를 이용하여 요청 메시지로부터 입력값들을 추출한다.
//각각의 입력 값들은 FileItem 객체 형태로 저장된다.

Iterator iter = items.iterator();
//순차적으로 접근하기 위한 Iterator 객체를 생성한다.

while (iter.hasNext()) { //더이상 요소가 없어질 때까지
	FileItem item = (FileItem) iter.next();
	String name = item.getFieldName();

	if (item.isFormField()) { //item이 이름 - 값 쌍으로 구성된 필드인지 확인
		//파라미터
		String value = item.getString("utf-8");
		if (name.equals("id")) {
	pid = value;

		} else if (name.equals("name")) {
	pname = value;
		} else if (name.equals("description")) {
	pdescription = value;
		} else if (name.equals("price")) {
	pprice = value;
		}
	} else {
		//사진
		if (name.equals("filename")) {
	pfname = item.getName();
	pfile = item.get();

	File file = new File("../photos" + "/" + pfname);
	item.write(file);
		}
	}

}


//현재 전달 받는 입력앖은 3개 = id,memo, filename 그중에 id memo는 필드값이고 filename 파일
//id와 memo는 getString(), filename은 getName(), get() 사진이름, 사진을 추출

ProductDAO dao = new ProductDAO();
	int code = dao.join(pid,pname,pdescription,pprice,pfname);
	
	if (code == 1){
		response.sendRedirect("/product/products.jsp");
	} else {
		response.sendRedirect("addProduct.jsp");
	}
%>