package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dclass.DB;


public class ReservedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//インスタンスの生成
		DB Add = new DB();
		String nextPage;
		request.setCharacterEncoding("UTF-8");
		//ユーザーセッション
		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("loginUser");
		String userID = Add.sMyreserve(loginID);


		//リクエストパラメータを受け取る
		String RoomID = request.getParameter("hdnRoomId");
		String Date = request.getParameter("date");
		String Start = request.getParameter("selStartTime");
		String End = request.getParameter("selEndTime");

		//戻り値を変数に入れる
		boolean res = Add.resAdd(userID,RoomID,Date,Start,End);

		//trueなら成功,falseなら失敗
		if(res){
			//成功時（true）遷移先
			nextPage = "MyreserveServlet";

		}else {
			//失敗時（false）遷移先
			nextPage = "form.jsp";
		}

		System.out.print(nextPage);
		RequestDispatcher rd = request.getRequestDispatcher("MyreserveServlet");
		rd.forward(request, response);
	}
}

