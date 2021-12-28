package com.koreait.gallery;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.File;
import java.util.List;
import java.io.PrintWriter;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;

public class GalleryServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws
		ServletException,IOException{
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();

		String saveDir= "D:/bigData/jsp_workspace/site3/data";
		File file = new File(saveDir);
		DiskFileItemFactory factory= new DiskFileItemFactory();
		factory.setSizeThreshold(1*1024*1024);
		factory.setRepository(file);

		try{
			ServletFileUpload fileUpload= new ServletFileUpload(factory);
			List<FileItem> fileItem= fileUpload.parseRequest(request);
			String title = null;
			String fileName= null;
			for ( int i =0;i<fileItem.size();i++){
				FileItem item= fileItem.get(i);
				
				if(item.isFormField()){
					title = item.getString("utf-8");
		
				}else{
					fileName= item.getName();
				}
				//拱府利牢 历厘

			File savedFile = new File(saveDir + "/" + fileName);
			item.write(savedFile);
			}
			out.print("历厘己傍!");
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}