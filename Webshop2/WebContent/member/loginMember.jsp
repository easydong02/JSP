<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="/resource/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
    <form class="form-signin" action = "loginCheck.jsp" method = "post">
  <img class="mb-4" src="/resource/image/dog.png" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">로그인</h1>
  <label for="inputEmail" class="sr-only">아이디</label>
  <input type="text" id="inputEmail" name = "id" class="form-control" placeholder="아이디" required autofocus>
  <label for="inputPassword" class="sr-only">비밀번호</label>
  <input type="password" id="inputPassword" name = "pass" class="form-control" placeholder="비밀번호" required>

  <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
  <p class="mt-5 mb-3 text-muted">&copy;Zaur 2021</p>
</form>
</body>
</html>