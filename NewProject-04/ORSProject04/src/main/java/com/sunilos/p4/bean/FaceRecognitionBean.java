package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FaceRecognitionBean extends BaseBean{

	private String faceCode;
	private String userName;
	private String imagePath;
	private String status;
	
	public String getFaceCode() {
		return faceCode;
	}

	public void setFaceCode(String faceCode) {
		this.faceCode = faceCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
			this.setFaceCode(rs.getString(2));
			this.setUserName(rs.getString(3));
			this.setImagePath(rs.getString(4));
			this.setStatus(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
