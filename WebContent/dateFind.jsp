<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
	<%@ page import="beans.SearchBean" %>
<!DOCTYPE html>
<html>
<body>
<!-- hedderあり -->

<div class="bg"></div>
<div class="bg bg2"></div>
<div class="bg bg3"></div>
<div class="content">
<%@ include file="hedder.jsp" %>
	<main>
		<h1>予約状況</h1>
		<% List<SearchBean> list2 = (List<SearchBean>)request.getAttribute("list1");%>
		<%if(list2.isEmpty()){%>
		<% out.print("検索日の予約は存在しません");}else if(list2 != null){%>
		<table>
		<% for(int i=0;i<list2.size();i++){ %>
		<tr>
		<td>日付:<% String date2 = list2.get(i).getDate();
				out.print(date2);%></td>
		<td>会議室名:<% String roomname2 = list2.get(i).getRoomName();
				out.print(roomname2);%></td>
		<td>開始時刻:<% String start2 = list2.get(i).getStart();
				out.print(start2+":00");%></td>
		<td>終了時刻:<% String end2 = list2.get(i).getEnd();
				out.print(end2+":00");%></td>
		</tr>
		<% }} %>
		</table>
	</main>
</div>
</body>
</html>
