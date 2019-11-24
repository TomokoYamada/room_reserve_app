package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RoomBean;
import dclass.DB;


public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db = new DB();
		String message;
		List<RoomBean> list = db.getListRoom();
		request.setAttribute("list", list);
		if(list.size() == 0) {
			message = "会議室はありません。";
		} else {
			message = null;
		}
		RequestDispatcher rd = request.getRequestDispatcher("owner.jsp");
		rd.forward(request, response);

	}

}
