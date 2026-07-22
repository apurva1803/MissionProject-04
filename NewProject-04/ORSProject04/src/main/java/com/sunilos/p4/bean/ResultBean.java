package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultBean extends BaseBean{

	private String studentId;
	private long percentage;
	private String grade;
	private String status;
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public long getPercentage() {
		return percentage;
	}

	public void setPercentage(long percentage) {
		this.percentage = percentage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setStudentId(rs.getString(2));
			this.setPercentage(rs.getInt(3));
			this.setGrade(rs.getString(4));
			this.setStatus(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
