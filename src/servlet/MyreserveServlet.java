package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SearchBean;
import dclass.DB;


public class MyreserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// セッション情報からIDを取得する
		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("loginUser");
		System.out.print(loginID);
		ArrayList<SearchBean> list=new ArrayList<SearchBean>();
		DB lo = new DB();
		list = lo.seMyreserve(loginID);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("reserved.jsp");
		rd.forward(request,response);
	}
}
