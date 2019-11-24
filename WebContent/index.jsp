

<!--  ログイン前のindex.jsp(hedderあり)  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="beans.SearchBean" %>
<% if((List<SearchBean>)request.getAttribute("list1") == null){
	response.sendRedirect("TodayServlet");
}%>
<!DOCTYPE html>
<html>
<div class="bg"></div>
<div class="bg bg2"></div>
<div class="bg bg3"></div>
<div class="content">
<!-- hedderあり -->

<%@ include file="hedder.jsp" %>
<br>
<head>
<meta charset="UTF-8">

<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c|Noto+Sans+JP|Noto+Serif+JP&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="index.css">
<title>Insert title here</title>
</head>


<body>
	<main>
		<h1>日付検索</h1>

		<form action="DateFindServlet" method="post">

			<select name="dateFindYear">
				<option value="2019">2019</option>
				<option value="2020">2020</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
				<option value="2025">2025</option>
			</select>年

			<select name="dateFindMonth">
				<option value="">-</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>月

			<select name="dateFindDay">
				<option value="">-</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
				</select>日


			<input type="submit" name="dateFind" value="検索">
		</form>

		<h1>当日の予約状況</h1>
			<%List<SearchBean> list2 = (List<SearchBean>)request.getAttribute("list1");%>
			<% System.out.print(list2); %>
			<%if(list2 ==null || list2.isEmpty()){%><br>
		<% out.print("本日の予約は存在しません");}else if(list2 != null){%>
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
		<% }}%>
		</table>
</div>


	</main>

</body>
</html>