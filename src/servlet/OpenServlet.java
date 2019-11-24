package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dclass.DB;

public class OpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを受け取る
		request.setCharacterEncoding("UTF-8");
		String roomID = request.getParameter("roomID");
		String url = null;
		System.out.println("あ");
		DB db = new DB();

		System.out.println("い");
		boolean openCheck = db.openCheck(roomID);
		System.out.println("う");
		if(openCheck) {
			url = "OwnerServlet";
		}else {
			url = "OwnerServlet";
		}
		System.out.println("か");
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);


		System.out.println("き");

	}


}
