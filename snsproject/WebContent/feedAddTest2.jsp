<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="util.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>

<%	String uid =null, ucon=null,ufname =null;
	byte[] ufile=null;
	
	request.setCharacterEncoding("utf-8");

	ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory()); //sfu 객체 생성 후 인자로 new DiskFileItemFactory()설정, 추출된 입력 값들을 FileItem 객체 형태로 저장하기 위해 사용 결과는 List 형태로 반환된다.
	List items= sfu.parseRequest(request);
	Iterator iter = items.iterator(); // List의 각 요소에 순차적으로 접근하기 위해Iterator 객체를 생성한다.

	while(iter.hasNext()){
		FileItem item = (FileItem)iter.next();
		String name = item.getFieldName();
		if(item.isFormField()){ //현재 item이 이름-값 쌍으로 구성된 경우 값을 추출
			String value=item.getString("utf-8");
			if(name.equals("id")){
				uid=value;
			}else if (name.equals("content")){
				ucon = value;
			}
		}else{
			if(name.equals("image")){
				ufname= item.getName();
				ufname = ufname.substring(ufname.lastIndexOf("\\"));
				ufile= item.get();
				
				String root = application.getRealPath(java.io.File.separator);
				FileUtil.saveImage(root,ufname,ufile);
				
				FeedDAO dao = new FeedDAO();
				if(dao.insert(uid,ucon,ufname)){
					response.sendRedirect("mainDAO.jsp");
				}else{
					out.print("업로드 중 에러 발생");
				}
			}
			
		}
	}

%>