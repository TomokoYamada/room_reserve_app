<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="bg"></div>
<div class="bg bg2"></div>
<div class="bg bg3"></div>

<div class="content">
<!-- hedderあり -->
<%@ include file="hedder.jsp" %>


	<main>
		<h1>新規会員登録</h1>

		<form action="InputServlet" method="post">
			名前　　　<input type="text" name="txtName"><br>
			ユーザーID<input type="text" name="txtUserId"><br>
			パスワード<input type="password" name="pwdLogin"><br>
			<input type="submit" name="submit" value="登録">
		</form>
	</main>

</body>
</html>
