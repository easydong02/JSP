<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">글 등록</h1>
		</div>
	</div>

	<div class="container">
		<form name="newMember" class="form-horizontal"
			action="addCheck.jsp" method="post"
			onsubmit="return checkForm()" enctype="multipart/form-data">
			<div class="form-group  row">
				<label class="col-sm-2 ">작성자</label>
				<div class="col-sm-3">
					<input name="member" type="text" class="form-control" placeholder="member">
				</div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2 ">글 제목</label>
				<div class="col-sm-3">
					<input name="title" type="text" class="form-control" placeholder="title">
				</div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2">글 내용</label>
				<div class="col-sm-3">
					<textarea name="content" rows=5, cols=20, class="form-control"
						placeholder="content"></textarea>
				</div>
			</div>

			<div class="form-group  row">
				<label class="col-sm-2">사진</label>
				<div class="col-sm-4">
					<input name="filename" type="file" class="form-control">
				</div>
			</div>
			<div class="form-group  row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary " value="등록 ">
					<input type="reset" class="btn btn-primary " value="취소 "
						onclick="reset()">
				</div>
			</div>
		</form>
	</div>



	<%@ include file="../footer.jsp"%>
</body>
</html>