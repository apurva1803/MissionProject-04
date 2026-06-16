package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerBean extends BaseBean{

	private String serverName;
	private String ipAddress;
	private double cpuUsage;
	private String status;
	
	
	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public double getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
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
		return serverName + "" +ipAddress;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setServerName(rs.getString(2));
			this.setIpAddress(rs.getString(3));
			this.setCpuUsage(rs.getDouble(4));
			this.setStatus(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
