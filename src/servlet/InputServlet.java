package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dclass.DB;

/**
 * Servlet implementation class InputServlet
 */
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("txtName");
		String loginID = request.getParameter("txtUserId");
		String password = request.getParameter("pwdLogin");

		DB lo = new DB();
		boolean check = lo.dupliCheck(loginID);

		if(check) {
			boolean recheck = lo.cusAdd(name, loginID, password);
			if(recheck) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginID);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("customer-input.jsp");
				rd.forward(request,response);
			}
		}


	}

}
