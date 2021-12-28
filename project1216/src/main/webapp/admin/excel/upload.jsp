<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.koreait.project1216.domain.Excel"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="org.apache.poi.ss.usermodel.CellType"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFCell"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFSheet"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFRow"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
		//클라이언트가 전송한 파일 데이터를 서버에 저장한 후, 그 엑셀파일을 읽어들여 다시 mysql에 넣자!!
		//업로드관련 설정(용량제한, 저장위치...)
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		/*
		File savePath = "";
		factory.setRepository(repository); */
		String realPath=application.getRealPath("/admin/excel/data"); //mac, 윈도우 상관 x
		out.print("실제 위치는 " +realPath+"<br>");
		
 		File file = new File(realPath);
		
		factory.setRepository(file); //업로드한 파일이 저장될 위치...
		factory.setSizeThreshold(1*1024*1024);
		
		//위에서 업로드 설정을 끝냈으므로, 지금부터는 업로드 시작!! ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory); //업로드 용량,경로 인식
		
		//업로드 시점은? 클라이언트가 전송한 요청에 대한 분석을 시도할 때...
		List<FileItem> itemList= upload.parseRequest(request);
		
		out.print(itemList.size()+"<br>");
		
		File uploadFile=null;
		for( FileItem item : itemList){
			if(item.isFormField()==false){//파일 컴포넌트임
				out.print(item.getName()+"<br>");
				uploadFile= new File(realPath +"/"+ item.getName());
				item.write(uploadFile);//물리적 저장  디렉토리명 /data.xls
			}
		}
		
		//2단계: 서버에 저장된 엑셀파일을 해석해서 db에 넣기
		FileInputStream fis = new FileInputStream(uploadFile);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		List<Excel> list = new ArrayList<Excel>();
		
		for(int i =1; i<=sheet.getLastRowNum();i++){
			HSSFRow row = sheet.getRow(i);
			Iterator it = row.iterator();
			Excel excel = new Excel(); //empty
			while(it.hasNext()){
				HSSFCell cell =(HSSFCell)it.next();
				if(cell.getCellType() == CellType.STRING){
					if(cell.getColumnIndex()==0){
						excel.setCategory(cell.getStringCellValue());
					}
					if(cell.getColumnIndex()==1){
						excel.setProduct_name(cell.getStringCellValue());
					}
					if(cell.getColumnIndex()==2){
						excel.setBrand(cell.getStringCellValue());
					}
				}else if(cell.getCellType() == CellType.NUMERIC){
					excel.setPrice(cell.getNumericCellValue());
				}
			}
			list.add(excel);
		}
		
		//DB연동하기
		InitialContext context = new InitialContext();
		DataSource ds=context.lookup("java:comp/env/jdbc/mysql");
		Connection con = ds.getConnection();
		
		String sql = "insert into excel(category,product_name,brand,price) values(?,?,?,?)";
		
		for(Excel obj :list){
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1, obj.getCategory());
			pstmt.setString(2, obj.getProduct_name());
			pstmt.setString(3, obj.getBrand());
			pstmt.setInt(4, obj.getPrice());
			pstmt.executeUpdate();
		}
		
		out.print("엑셀에서 디비로 마이그레이션");
		
		con.close();
		
		
		if(fis!=null){
			fis.close();
		}
		
		
		
%>