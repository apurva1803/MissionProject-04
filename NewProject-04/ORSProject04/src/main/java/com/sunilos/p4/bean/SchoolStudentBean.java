package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolStudentBean extends BaseBean{

	private String name;

	private String email;

	private String mobileNo;

	private String course;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return course ;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setName(rs.getString(2));
			this.setEmail(rs.getString(3));
			this.setMobileNo(rs.getString(4));
			this.setCourse(rs.getString(5));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
