package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SearchBean;
import dclass.DB;


public class DateFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String year = request.getParameter("dateFindYear");
		String month = request.getParameter("dateFindMonth");
		String day = request.getParameter("dateFindDay");
		String date = year+"-"+month+"-"+day;
		DB db = new DB();
		List<SearchBean> list = db.today(date);
		//取得したDBデータを格納
		request.setAttribute("list1",list);
		RequestDispatcher rd = request.getRequestDispatcher("dateFind.jsp");
		rd.forward(request, response);
	}
}