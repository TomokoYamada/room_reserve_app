package beans;

import java.io.Serializable;

public class RoomBean implements Serializable{
	//フィールド変数
	private static final long serialVersionUID =1L;
	private String roomID;
	private String roomName;
	private String capacity;
	private String open;

	//コンストラクタ
	public RoomBean() {}
	public RoomBean(String roomID,String roomName,String capacity,String open) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.capacity = capacity;
		this.open = open;
	}
	public String getRoomID() {
		return roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public String getCapacity() {
		return capacity;
	}
	public String getOpen() {
		return open;
	}
}
