package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HostelBean extends BaseBean{

	private String ownerName;
	private String location;
	private int rent;
	private String roomType;
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public String getKey() {
		return "id";
	}

	@Override
	public String getValue() {
		return location + "" + rent;
	}

	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setOwnerName(rs.getString(2));
			this.setLocation(rs.getString(3));
			this.setRent(rs.getInt(4));
			this.setRoomType(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
