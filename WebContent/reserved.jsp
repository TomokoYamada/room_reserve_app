<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.SearchBean" %>
    <%@ page import="dclass.DB" %>
    <%@ page import="java.util.List" %>

<div class="bg"></div>
<div class="bg bg2"></div>
<div class="bg bg3"></div>
<div class="content">
<!-- hedderあり -->
<%@ include file="hedder.jsp" %>
	<main>


		<h1>MY予約状況</h1>
		<table>
			<tr>
				<th>会議室名</th>
				<th>収容数</th>
				<th>日付</th>
				<th>開始時刻</th>
				<th>終了時刻</th>
                <th></th>
			</tr>
			<% List<SearchBean> list=(List<SearchBean>)request.getAttribute("list"); %>


                <% for(int i=0;i<list.size();i++){ %>
<td><% String roomName = list.get(i).getRoomName();
				out.print(roomName);%></td>
<td><% String capacity= list.get(i).getCapacity();
				out.print(capacity);%></td>
<td><% String date = list.get(i).getDate();
				out.print(date);%></td>
<td><% String start = list.get(i).getStart();
				out.print(start);%></td>
<td><% String end = list.get(i).getEnd();
				out.print(end);%></td>


		<td><form action="CancelServlet" method="post">
		<input type="hidden" name="cxl" value="<% String resID = list.get(i).getResID();
				out.print(resID);%>">
<input type="submit" value="キャンセル">
</td>
</form>

</tr>
<% } %>
</table>

</main>

</body>
</html>
