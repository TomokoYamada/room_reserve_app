<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- hedderあり -->



<%@ include file="hedder.jsp" %>

<body>
	<main>
		<h1>ログイン</h1>
		<form action="LoginServlet" method="post">
			ユーザーID<input type="text" name="txtUserId" value=""><br>
			パスワード<input type="password" name="pass" value=""><br>
			<input type="submit" name="login" value="ログイン">
		</form>
	</main>

</body>
</html>
