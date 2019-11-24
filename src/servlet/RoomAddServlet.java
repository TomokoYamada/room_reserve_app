package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dclass.DB;

public class RoomAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    this.doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //リクエストパラメータを受け取る
    System.out.print("あ");
    request.setCharacterEncoding("UTF-8");
    String roomName = request.getParameter("roomName");
    String capacity = request.getParameter("capacity");
    System.out.print("あ");
    DB db = new DB();
    boolean check = db.roomAddCheck(roomName);
    System.out.print("い");
    if(check) {
      boolean add = db.roomAdd(roomName, capacity);
    }
    System.out.print("う");
    RequestDispatcher rd = request.getRequestDispatcher("OwnerServlet");
    rd.forward(request, response);
  }
}