package beans;

import java.io.Serializable;

public class SearchBean implements Serializable{
	//フィールド変数
	private static final long serialVersionUID = 1L;
	private String roomName;
	private String capacity;
	private String date;
	private String start;
	private String end;
	private String resID;

	//コンストラクタ
	public SearchBean() {}
	public SearchBean(String roomName,String capacity,String date,String start,String end,String reservationID) {
		this.roomName = roomName;
		this.capacity = capacity;
		this.date = date;
		this.start = start;
		this.end = end;
		this.resID = resID;
	}
	public String getRoomName() {
		return roomName;
	}
	public String getCapacity() {
		return capacity;
	}
	public String getDate() {
		return date;
	}
	public String getStart() {
		return start;
	}
	public String getEnd() {
		return end;
	}
	public String getReservationID() {
		return reservationID;
	}


}

