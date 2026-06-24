package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleBean extends BaseBean{

	private String vehicleNo;
	private String ownerName;
	private String model;
	private String color;
	
	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return model + "";
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setVehicleNo(rs.getString(2));
			this.setOwnerName(rs.getString(3));
			this.setModel(rs.getString(4));
			this.setColor(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
