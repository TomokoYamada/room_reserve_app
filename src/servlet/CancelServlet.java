package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dclass.DB;

/**
 * Servlet implementation class CancelServlet
 */
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");

	String resID = request.getParameter("cxl");
	String url;
	System.out.print(resID);

	DB lo = new DB();
	boolean check = lo.resCancel(resID);
	if(check) {
		url = "index.jsp";
	}else {
		url = "index.jsp";
	}
	System.out.print(url);
	RequestDispatcher rd = request.getRequestDispatcher(url);
	rd.forward(request,response);
	}
}