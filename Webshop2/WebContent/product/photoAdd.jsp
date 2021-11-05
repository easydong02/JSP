<%@page import="dao.ProductObj"%>
<%@page import="dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
    
<%
   String uid = null, umemo = null, ufname = null;
   byte[] ufile = null;

   request.setCharacterEncoding("UTF-8");

   ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
   //추출된 값들을 FileItem 객체의 형태로 저장하기 위해서 준비
   
   List items = sfu.parseRequest(request);
   // parseRequest() 함수를 이용하여 요청 메세지로부터 입력 값들을 추출한다.
   // 각각의 입력 값들은 FileItem 객체 형태로 저장된다.
   Iterator iter = items.iterator();
   //순차적으로 접근하기 위한 Iterator 객체를 생성한다.
   
   while(iter.hasNext()){
      FileItem item = (FileItem) iter.next();
      String name = item.getFieldName();
      if(item.isFormField()){      // item이 이름 - 값 쌍으로 구성된 필드인지 확인 
         //파라미터
         String value = item.getString("utf-8");
         if(name.equals("id")) uid = value;
         else if(name.equals("memo")) umemo = value;
      } else {
         //사진 photo는 getName(), get() 사진이름, 사진을 추출
         if(name.equals("filename")){
            ufname = item.getName();
            ufile = item.get();
            
            File file = new File("D:\\photos" + "/" + ufname);
            item.write(file);
         }
      }
   }

   //현재 전달 받는 입력값은 3개 id memo photo 그 중에 id memo는 필드값이고 photo는 파일
   // id와 memo는 getString(), photo는 getName(), get()사진이름, 사진을 추출
   
   ArrayList<ProductObj> products = new ArrayList<ProductObj>();
   
   for( ProductObj product : products){
	   
	   
   }
   
%>
   <%=uid %><br>
   <%=umemo %><br>
   <%=ufname %><br>
