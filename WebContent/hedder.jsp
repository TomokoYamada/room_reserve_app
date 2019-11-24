<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c|Noto+Sans+JP|Noto+Serif+JP&display=swap" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="index.css">
<title>Insert title here</title>
</head>
<body>

	<header>
		<form action="index.jsp">
			<input type="submit"  class="button" name="top" value="　　TOP　　">
		</form>

		<form action="MyreserveServlet">
			<input type="submit"  class="button" name="reserved" value="MY予約状況">
		</form>

		<form action="form.jsp">
			<input type="submit"  class="button" name="form" value="予約フォーム">
		</form>
        <form action="customer-input.jsp">
			<input type="submit"  class="button" name="logput" value="　新規登録　">
		</form>
		<form action="login.jsp">
			<input type="submit"  class="button" name="logput" value="　ログイン　">
		</form>
		<form action="LogoutServlet">
			<input type="submit"  class="button" name="logput" value="　ログアウト　">
		</form>



	</header>