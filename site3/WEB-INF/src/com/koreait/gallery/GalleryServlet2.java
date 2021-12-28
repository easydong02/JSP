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

	//Ŭ���̾�Ʈ�� ��û�� ó���� �޼��带 ������
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//Ŭ���̾�Ʈ�� ������ �Ķ���͸� �޾Ƽ�, ���ε带 ����..
		
		response.setContentType("text/html;charset=utf-8");
		
		//�Ķ���� �ޱ�!!
		request.setCharacterEncoding("utf-8");//�Ķ���Ϳ� ���� ���ڵ�ó��
		//String title =request.getParameter("title");
		
		//����������ü�κ��� ��½�Ʈ�� ����
		PrintWriter out=response.getWriter();

		//����ġ ���Ͼ��ε带 �̿��Ͽ� ���ε� ����
		String saveDir="D:/bigData/jsp_workspace/site3/data ";
		factory = new DiskFileItemFactory();//���ε� ������ü (���Ͽ뷮����, ������...)
		File file = new File(saveDir);//�Ϲ�Ŭ������ new
		factory.setRepository(file);//������ ����
		factory.setSizeThreshold(1*1024*1024);//���� �뷮 ����

		try{
			ServletFileUpload fileUpload =  new ServletFileUpload(factory); //���ε带 ó���ϴ� �ٽɰ�ü!
			
			//���ε� ó��!!
			List<FileItem> itemList =fileUpload.parseRequest(request); //multipart�� ���������� ���۵����͸� �м�..
			out.print("����� ���ε��� ������Ʈ���� ���� " +itemList.size()+"<br>");
			for (int i=0;i<itemList.size();i++ ){
				FileItem item= itemList.get(i);//�ϳ��������� text�ʵ�� dbó��, �����̸� ����ó��..
				if (item.isFormField()){//�ؽ�Ʈ ��
					//�ؽ�Ʈ �ʵ��� �� ����
					String title= item.getString("utf-8");
					
					out.print("���� �����̴� : "+ title);
				}else{//�ƴϸ� ����������Ʈ��..
					out.print("���ε��� ���ϸ���: "+item.getName());
					
					
					File saveFile= new File(saveDir+"/" +item.getName());
					item.write(saveFile);//�������� ����
					out.print("�������� ����<br>");
				}
			}
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
