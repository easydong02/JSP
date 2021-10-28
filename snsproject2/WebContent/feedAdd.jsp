<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="util.*"%>

<%	request.setCharacterEncoding("utf-8");

	String uid =null,ucon=null,ufname=null;
	byte[] ufile = null;
	
	ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
	List items= sfu.parseRequest(request);

	Iterator iter= items.iterator();
	
	while(iter.hasNext()){
		FileItem item = (FileItem) iter.next();
		String name = item.getFieldName();
		if(item.isFormField()){
			String value=item.getString("utf-8");
			if(name.equals("id")){
				uid=value;
			}else if(name.equals("content")){
				ucon= value;
			}
		}else{
			if(name.equals("image")){
				ufname = item.getName();
				ufname= ufname.substring(ufname.lastIndexOf(("\\")));
				ufile = item.get();
				
				String root = application.getRealPath(java.io.File.separator);
				FileUtil.saveImage(root,ufname,ufile);
				
				FeedDAO dao =new FeedDAO();
				if(dao.insert(uid,ucon,ufname)){
					response.sendRedirect("main.jsp");
				}else{
					out.print("오류 발생");
				}
			}
		}
	}
	
	
	
	
%>