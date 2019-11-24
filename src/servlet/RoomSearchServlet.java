package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RoomBean;
import dclass.DB;

public class RoomSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("o");
		//リクエストパラメータを受け取る
		String year = request.getParameter("dateYear");
		String month = request.getParameter("dateMonth");
		String day = request.getParameter("dateDay");
		String people = request.getParameter("txtResPeople");
		String start = request.getParameter("selStartTime");
		String end = request.getParameter("selEndTime");
		System.out.println("p");
		ArrayList<String> list3 = new ArrayList<String>();
		ArrayList<String> list4 = new ArrayList<String>();
		System.out.println("q");
		DB db = new DB();
		String message = null;
		String date = year + "-" + month + "-" + day;
		boolean check = true;
		System.out.println("r");
		List<RoomBean> list1 = db.getListByDate(people,date,start,end);
		System.out.println("s");
		List<RoomBean> list2 = db.getListRoom();
		System.out.println("t");
		for(int i=0;i<list2.size();i++) {
			check =true;
			for(int j=0;j<list1.size();j++) {
				if(!(list2.get(i).getRoomID()==list1.get(j).getRoomID())) {
					check=false;
					System.out.println("u");
				}
			}
			if(check==true) {
				list3.add(list2.get(i).getRoomName());
				list4.add(list2.get(i).getRoomID());

			}
		}
		System.out.println("h");
	request.setAttribute("list",list3);
	request.setAttribute("list2",list4);
	request.setAttribute("date",date);
	request.setAttribute("start",start);
	request.setAttribute("end",end);
	RequestDispatcher rd = request.getRequestDispatcher("form2.jsp");
	rd.forward(request, response);
	}
}

