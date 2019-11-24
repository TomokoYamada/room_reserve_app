<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.*" %>


<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c|Noto+Sans+JP|Noto+Serif+JP&display=swap" rel="stylesheet">

<!-- hedderあり -->

 <div class="bg"></div>
<div class="bg bg2"></div>
<div class="bg bg3"></div>
<div class="content">
<%@ include file="hedder.jsp" %>


		<main>


		<h1>予約</h1>
		<form action="RoomSerchServlet" method="post">
			予約希望日<select name="dateYear">
						<%for (int i = 2019; i <= 2025; i++) {
							out.print("<option value=\"" + i + "\">" + i + "</option>");
						}%>
						</select>
						<select name="dateMonth">
						<%for (int i = 1; i <= 12; i++) {
							out.print("<option value=\"" + i + "\">" + i + "</option>");
						}%>
						</select>
						<select name="dateDay">
						<%for (int i = 1; i <= 31; i++) {
							out.print("<option value=\"" + i + "\">" + i + "</option>");
						}%>
						</select><br>

			予約人数<input type="text" name="txtResPeople"><br>
			開始時刻<select name="selStartTime">
						<%for (int i = 9; i <= 19; i++) {
							out.print("<option value=\"" + i + "\">" + i + "</option>");
						}%>
					</select>時～<br>
			終了時刻<select name="selEndTime">
						<%for (int i = 10; i <= 20; i++) {
							out.print("<option value=\"" + i + "\">" + i + "</option>");
						}%>
					</select>時<br>
			<input type="submit" value="検索">
		</form>

<%
	List<String> list = (List<String>)request.getAttribute("list");
    List<String> list2 = (List<String>)request.getAttribute("list2");
	Boolean flg = false;
	if(flg){
		String x = "style=display:none";
	}
	String mes = (String)request.getAttribute("mes");
%>



		<table>
		<tr>
			<th>部屋</th>
			<th></th>
		</tr>
		<%	for (int i=0; i<list.size(); i++){ %>
		<tr>
            <form action="ReservedServlet" method="post">
            <td><% out.print(list.get(i)); %></td>
			<input type=hidden name="date" value='<% out.print((String)request.getAttribute("date")); %>'>
			<input type=hidden name="selStartTime" value='<% out.print((String)request.getAttribute("start")); %>'>
			<input type=hidden name="selEndTime" value='<% out.print((String)request.getAttribute("end")); %>'>
			<input type=hidden name="hdnRoomId" value="<% out.print(list2.get(i)); %>">
			<td><input type=submit value="選択"></td>
			</form>
		</tr>

		<% } %>
		</table>

	</main>
</div>
</body>
</html>
