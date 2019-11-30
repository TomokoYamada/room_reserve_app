package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dclass.DB;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String[]ary = new String[2];
	String url;
	String userID = request.getParameter("txtUserId");
	String pass = request.getParameter("pass");

	DB lo = new DB();
	ary = lo.loCheck(userID, pass);
	HttpSession session = request.getSession();
	System.out.print(ary[1]);
	switch(ary[0]){
		case "オーナー":
			session.setAttribute("loginUser", ary[1]);
			url = "OwnerServlet";
			break;
	case "顧客":
		session.setAttribute("loginUser", ary[1]);
		url = "index.jsp";
		break;
	default:
		url = "login.jsp";
		break;

	}

	RequestDispatcher rd = request.getRequestDispatcher(url);
	rd.forward(request,response);
	}

}
