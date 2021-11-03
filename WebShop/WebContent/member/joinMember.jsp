<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../_header.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="dispaly-3">회원가입</h1>
		</div>
	</div>
	<form action="joinCheck.jsp" method = "post">
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputEmail4">아이디</label> <input type="text"
					class="form-control" name = "id"id="inputEmail4" placeholder="아이디">
			</div>
			<div class="form-group col-md-6">
				<label for="inputPassword4">비밀번호</label> <input type="password"
					class="form-control"name = "pass" id="inputPassword4" placeholder="비밀번호">
			</div>
		</div>
		<div class="form-group">
			<label for="inputAddress">주소</label> <input type="text"
				class="form-control"  name = "addr1" id="inputAddress" placeholder="예) 대림로 29가길 10">
		</div>
		<div class="form-group">
			<label for="inputAddress2">주소2</label> <input type="text"
				class="form-control" name = "addr2" id="inputAddress2" placeholder="예) 101동 202호">
		</div>
		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="inputCity">생일</label> <input type="text"
					class="form-control"name = "birth" id="inputCity">
			</div>
			<div class="form-group col-md-6">
				<label for="inputZip">이메일</label> <input type="text"
					class="form-control" name = "email" id="email">
			</div>
			<div class="form-group col-md-2">
				<label for="inputZip">전화번호</label> <input type="text"
					class="form-control"name = "phone" id="email">
			</div>
		</div>
		<div class="form-group">
				<label for="inputZip">성별</label> <input type="radio" value ="남"
					 name = "gender" id="gender">남
				<label for="inputZip"></label> <input type="radio" value ="여"
					 name = "gender" id="gender">여
			</div>
		<button type="submit" class="btn btn-primary">가입</button>
	</form>
	<jsp:include page="../_footer.jsp" />
</body>
</html>