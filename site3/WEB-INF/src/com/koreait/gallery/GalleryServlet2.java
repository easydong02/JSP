package com.koreait.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;


public class GalleryServlet extends HttpServlet{
	DiskFileItemFactory factory;

	//클라이언트의 요청을 처리할 메서드를 재정의
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//클라이언트가 전송한 파라미터를 받아서, 업로드를 구현..
		
		response.setContentType("text/html;charset=utf-8");
		
		//파라미터 받기!!
		request.setCharacterEncoding("utf-8");//파라미터에 대한 인코딩처리
		//String title =request.getParameter("title");
		
		//응답정보객체로부터 출력스트림 열기
		PrintWriter out=response.getWriter();

		//아파치 파일업로드를 이용하여 업로드 구현
		String saveDir="D:/bigData/jsp_workspace/site3/data ";
		factory = new DiskFileItemFactory();//업로드 설정객체 (파일용량제한, 저장경로...)
		File file = new File(saveDir);//일반클래스라 new
		factory.setRepository(file);//저장경로 지정
		factory.setSizeThreshold(1*1024*1024);//파일 용량 제한

		try{
			ServletFileUpload fileUpload =  new ServletFileUpload(factory); //업로드를 처리하는 핵심객체!
			
			//업로드 처리!!
			List<FileItem> itemList =fileUpload.parseRequest(request); //multipart한 복합형태의 전송데이터를 분석..
			out.print("당신이 업로드한 컴포넌트들의 수는 " +itemList.size()+"<br>");
			for (int i=0;i<itemList.size();i++ ){
				FileItem item= itemList.get(i);//하나씩꺼내서 text필드면 db처리, 파일이면 저장처리..
				if (item.isFormField()){//텍스트 폼
					//텍스트 필드의 값 추출
					String title= item.getString("utf-8");
					
					out.print("나는 제목이다 : "+ title);
				}else{//아니면 파일컴포넌트임..
					out.print("업로드한 파일명은: "+item.getName());
					
					
					File saveFile= new File(saveDir+"/" +item.getName());
					item.write(saveFile);//물리적인 저장
					out.print("파일저장 성공<br>");
				}
			}
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
