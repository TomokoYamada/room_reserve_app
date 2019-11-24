package dclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.RoomBean;
import beans.SearchBean;


public class DB {
	private Connection con = null;
	public DB() {
	}

	//データベース接続メソッド
	public void dbConnect() {
		this.con = null;
		try {
			//コンテキストの取得
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/eroom");
			this.con = ds.getConnection();
		}catch(Exception ex){
			ex.getMessage();
			System.out.print("A");
			return;
		}
	}

	//ログイン
	public String[] loCheck(String userID,String pass) {
		this.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		String[]ary = new String[2];
		try{
			System.out.print("a");
			if(userID == null || userID.length() == 0 || pass == null || pass.length() == 0) {
				ary[0]="なし";
				ary[1]="空";
			}
			System.out.print("b");
			String sql = "select * from owner where ownerID=? and password=?";
			ps = this.con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, pass);
			rs = ps.executeQuery();

			System.out.print("c");
			String sqls = "select * from customer where loginID=? and password=?";
			ps2 = this.con.prepareStatement(sqls);
			ps2.setString(1, userID);
			ps2.setString(2, pass);
			rs2 = ps2.executeQuery();
			System.out.print("d");
			if(rs.next()) {
				ary[0] = "オーナー";
				String kari = rs.getString("ownerID");
				ary[1] = kari;

			}else if(rs2.next()) {
				ary[0] = "顧客";
				String kari = rs2.getString("loginID");
				ary[1] = kari;

			}else {
				ary[0] = "なし";
				ary[1] = "空";
			}
			System.out.print("e");
		}catch(Exception ex){
			System.out.print("通過ログインチェックnull");
			System.err.println(ex.getMessage());
			return null;

		}finally {
			try {
				if(rs != null && rs2 != null) {
					rs.close();
				}
				if(ps != null && ps2 != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}

		}
		return ary;
	}
	
	public boolean dupliCheck(String loginID) {
		this.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			System.out.print("a");

			System.out.print("b");
			String sql = "select * from customer where loginID=?";
			ps = this.con.prepareStatement(sql);
			ps.setString(1, loginID);
			rs = ps.executeQuery();

			System.out.print("c");

			System.out.print("d");
			if(rs.next()) {
				return false;

			}else {
				return true;
			}

		}catch(Exception ex){
			System.out.print("通過ログインチェックnull");
			System.err.println(ex.getMessage());
			return false;

		}finally {
			try {
				if(rs != null ) {
					rs.close();
				}
				if(ps != null ) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}

			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	public boolean customerAdd(String name,String loginID,String password) {
		this.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rs2;
		try{
			System.out.print("a");

			System.out.print("b");
			String sql = "Insert into customer values(null,?,?,?)";
			ps = this.con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, loginID);
			ps.setString(3, password);
			rs2 = ps.executeUpdate();

			System.out.print("c");

			return true;


		}catch(Exception ex){
			System.out.print("通過ログインチェックnull");
			System.err.println(ex.getMessage());
			return false;

		}finally {
			try {
				if(rs != null ) {
					rs.close();
				}
				if(ps != null ) {
					ps.close();
				}
				if(con !=null) {
					con.close();
				}

			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

	public ArrayList<SearchBean> seMyreserve(String loginID) {
		this.dbConnect();
		ArrayList<SearchBean> list = new ArrayList<SearchBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		String UserID = null;

		try{
			System.out.print("a");

			System.out.print("b");
			String sql = "select * from customer where loginID=?";
			ps = this.con.prepareStatement(sql);
			ps.setString(1,loginID);
			rs = ps.executeQuery();

			System.out.print("c");
			while(rs.next()) {
				UserID = rs.getString("userID");
				System.out.print("c+");
			}
			String sql2 = "SELECT * FROM room,reservation where userID=? and status=0 and reservation.roomID=room.roomID";
			ps2 = this.con.prepareStatement(sql2);
			ps2.setString(1,UserID);
			rs2=ps2.executeQuery();
			System.out.print("d");
			while(rs2.next()) {
				String roomName = rs2.getString("roomName");
				String capacity = rs2.getString("capacity");
				String date = rs2.getString("date");
				String start = rs2.getString("start");
				String end = rs2.getString("end");
				String resID = rs2.getString("resID");

				SearchBean sb = new SearchBean(roomName,capacity, date, start, end, resID);
				list.add(sb);

			}

			System.out.print("e");
			System.out.print(list);
		}catch(Exception ex){
			System.out.print("通過ログインチェックnu");
			System.err.println(ex.getMessage());
			return null;

		}finally {
			try {
				if(rs != null ) {
					rs.close();
				}
				if(ps != null ) {
					ps.close();
				}
				if(con != null) {
					con.close();

				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}

		}
		return list;
	}

	public String sMyreserve(String loginID) {
		this.dbConnect();

		PreparedStatement ps = null;
		ResultSet rs = null;

		String UserID = null;

		try{
			System.out.print("a");

			System.out.print("b");
			String sql = "select * from customer where loginID=?";
			ps = this.con.prepareStatement(sql);
			ps.setString(1,loginID);
			rs = ps.executeQuery();

			System.out.print("c");
			while(rs.next()) {
				UserID=rs.getString("userID");
				System.out.print("c+");
			}

			return UserID;
		}catch(Exception ex){
			System.out.print("通過ログインチェックnu");
			System.err.println(ex.getMessage());
			return null;

		}finally {
			try {
				if(rs != null ) {
					rs.close();
				}
				if(ps != null ) {
					ps.close();
				}
				if(con != null) {
					con.close();

				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}

		}

	}
	//管理ページメソッド
	//会議室一覧表示メソッド
	public List<RoomBean> getListRoom() {
		List<RoomBean> list = new ArrayList<RoomBean>();
		this.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.print("a");
		try {
			String sql = "SELECT * FROM room";
			ps = this.con.prepareStatement(sql);
			rs = ps.executeQuery();
			//データ取得
			while(rs.next()) {
				System.out.print("b");

				String roomID = rs.getString("roomId");
				String roomName = rs.getString("roomName");
				String capacity = rs.getString("capacity");
				String open = rs.getString("open");

				System.out.print("c");


				if(open.equals("0")) {
					open = "非公開";
				}else {
					open = "公開";
				}
				System.out.print("d");

				RoomBean room = new RoomBean(roomID,roomName,capacity,open);
				list.add(room);
			}
		}catch(Exception ex) {
			System.out.print("e");
			System.err.println(ex.getMessage());
			return null;

		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
				System.out.print("n");
			}
		}
		System.out.print("f+");
		return list;
	}
	//部屋追加メソッド（重複確認）
	public  boolean roomAddCheck(String roomName){
		this.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Change = null;
		try {
			System.out.print("1");
			String sql = "Select * From room Where roomName = ?";
			ps = this.con.prepareStatement(sql);
			ps.setString(1, roomName);
			rs = ps.executeQuery();
			System.out.print("2");
		//リストにデータを追加する
			while (rs.next()) {
				return false;
			}
			//リストがからの場合、falseを返す
			System.out.print("3");
			return true;
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			return false;

		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	//部屋追加メソッド
	public boolean roomAdd(String roomName, String capacity) {
		this.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			System.out.print("a");
			String sql = "insert into room Values(null,?,?,1)";
			ps = this.con.prepareStatement(sql);
			ps.setString(1, roomName);
			ps.setString(2, capacity);
			int update = ps.executeUpdate();
			System.out.print("b");
				if(update != 0) {
					System.out.print("c");
				return true;

			} else {
				System.out.print("d");
				return false;
			}


		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			return false;

		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}




	//公開非公開変更メソッド
	public boolean openCheck(String roomID) {
		this.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		String sql2;

		try {
			System.out.println("さ");
			String sql = "SELECT open FROM room WHERE roomID = ?";
			ps = this.con.prepareStatement(sql);
			ps.setString(1,roomID);
			rs = ps.executeQuery();
			String open = null;

			while(rs.next()) {
				open = rs.getString("open");
			}

			System.out.println("し");

			System.out.println("す");
			//openの値が０なら１に。１なら０にUPDATEする
			if(open.equals("0")){
				sql2 = "UPDATE room SET open = 1 WHERE roomID = ?";
				System.out.println("せ");
			}else{
				sql2 = "UPDATE room SET open = 0 WHERE roomID = ?";
				System.out.println("そ");
			}
			System.out.println("た");

			ps2 = this.con.prepareStatement(sql2);
			ps2.setString(1, roomID);

			int n = ps2.executeUpdate();
			System.out.println("ち");
			//更新された行がある場合はtrueを返す
			if(n != 0){
				System.out.println("ち");
				return true;
			}else{
				System.out.println("つ");
				return false;
			}
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			return false;

		}finally {
			try {
				if(rs != null ) {
					rs.close();
				}
				if(ps != null ) {
					ps.close();
				}
				if(con !=null) {
					con.close();
				}

			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}



	//部屋検索メソッド
	public List<RoomBean> getListByDate(String people,String date, String start, String end) {
		System.out.println("1");
		List<RoomBean> list = new ArrayList<RoomBean>();

		this.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("2");
		try {
			String sql = "SELECT * FROM reservation WHERE status = 0 AND date = ? AND ((start<? AND ?<end) OR (start<? AND ?<end))";
			System.out.println("3");
			ps = this.con.prepareStatement(sql);
			ps.setString(1,date);
			ps.setString(2,start);
			ps.setString(3,start);
			ps.setString(4,end);
			ps.setString(5,end);
			rs = ps.executeQuery();
			System.out.println("4");
			while(rs.next()) {
				String roomID = rs.getString("roomID");
				String roomName = rs.getString("roomName");
				String capacity = rs.getString("capacity");
				String open = rs.getString("open");
				System.out.println("5");
				RoomBean room = new RoomBean(roomID,roomName,capacity,open);
				list.add(room);
				System.out.println("6");
			}
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			return null;

		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(this.con != null) {
					this.con.close();
				}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		System.out.println("7");
		return list;

}


		public boolean resCancel(String resID) {
			this.dbConnect();
			PreparedStatement ps = null;
			ResultSet rs = null;
			int rs2;
			try{
				System.out.print("a");

				System.out.print("b");
				String sql = "update reservation set status=1 where resID=?";
				ps = this.con.prepareStatement(sql);
				ps.setString(1,resID);
				rs2 = ps.executeUpdate();

				System.out.print("c");

				return true;


			}catch(Exception ex){
				System.out.print("通過ログインチェックnull");
				System.err.println(ex.getMessage());
				return false;

			}finally {
				try {
					if(rs != null ) {
						rs.close();
					}
					if(ps != null ) {
						ps.close();
					}
					if(con != null) {
						con.close();

					}
				}catch(Exception ex) {
					System.err.println(ex.getMessage());
				}

			}

		}


	public boolean resAdd(String userID,String RoomID,String Date,String Start,String End) {

		this.dbConnect();
		PreparedStatement ps = null;

		try{
			//DBクラスにまとめる（予約完了処理(resAddメソッド)）
			String sql = "INSERT INTO reservation VALUES(null,?,?,?,?,?,0)";
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, RoomID);
			ps.setString(3, Date);
			ps.setString(4, Start);
			ps.setString(5, End);

			int ret = ps.executeUpdate();

			if(ret != 0) {
				return true;
			}else {
				return false;
			}


		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			return false;

		}finally {
			try{
					if(ps != null) {
						ps.close();
					}
					if(con != null) {
						con.close();
					}
			}catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}


	public List<SearchBean> today(String day) {
		List<SearchBean> list = new ArrayList<SearchBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//データベース接続
			this.dbConnect();
			//SQLの生成
			String sql = "select * from room,reservation where date=? AND reservation.status=0 AND room.roomID = reservation.roomID ORDER BY date ASC";
			ps = con.prepareStatement(sql);
			ps.setString(1,day);
			rs = ps.executeQuery();
			//取得できる値の数だけlistに格納する
			while(rs.next()) {
				String roomName = rs.getString("roomName");
				String date = rs.getString("date");
				String start = rs.getString("start");
				String end = rs.getString("end");
				String capacity = rs.getString("capacity");
				String resID = rs.getString("resID");
				SearchBean lists = new SearchBean(roomName,capacity,date,start,end,resID);
				list.add(lists);
			}
		}catch(Exception e) {
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				//データベースに接続されていれば切断する
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
			}
		}
		return list;
}

}

