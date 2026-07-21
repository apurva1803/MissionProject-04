package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SmartParkingBean extends BaseBean{

	private String parkingCode;
	private String vehicleNumber;
	private String slotNumber;
	private String status;
	
	public String getParkingCode() {
		return parkingCode;
	}
	public void setParkingCode(String parkingCode) {
		this.parkingCode = parkingCode;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String getKey() {
		return id + "";
	}
	@Override
	public String getValue() {
		return status;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setParkingCode(rs.getString(2));
			this.setVehicleNumber(rs.getString(3));
			this.setSlotNumber(rs.getString(4));
			this.setStatus(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
