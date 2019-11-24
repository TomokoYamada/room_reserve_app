<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

	<%@ page import="beans.RoomBean"%>
	<%@ page import="dclass.DB"%>
	<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>管理ページ</h1>

	<table>

		<tr>
			<th>会議室ID</th>
			<th>会議室名</th>
			<th>収容人数</th>
			<th>現在の状況</th>
			<th></th>
		</tr>
		<%
		List<RoomBean> list = (List<RoomBean>)request.getAttribute("list");

		 for(int i=0;i< list.size();i++){ %>
			<tr>
			<td><% String roomID = list.get(i).getRoomID();
				out.print(roomID);%></td>
			<td><% String roomName = list.get(i).getRoomName();
				out.print(roomName);%></td>
			<td><% String capacity = list.get(i).getCapacity();
				out.print(capacity);%></td>
			<td><% String open = list.get(i).getOpen();
				out.print(open);%></td>
			<td>
				<form action="OpenServlet" method="post">
				<input type="hidden" name="roomID" value="<% String ID = list.get(i).getRoomID();
				out.print(roomID);%>">
				<input type="submit" name="close" value="切替">

				</form>
			</td>
		</tr>
	<% 	} %>

</table>
<form action="RoomAddServlet" method="post">
		<input type="text" name="roomName">
<input type="text" name="capacity">
<input type="submit" name="add" value="追加">
	</form>
	<form action="LogoutServlet" method="post">
		<input type="submit" name="logout" value="ログアウト">
	</form>



</body>
</html>