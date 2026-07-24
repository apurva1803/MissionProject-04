package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CollegeMBean extends BaseBean{

	private String collegeName;
	private String city;
	private String university;
	private String contactNo;
	
	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return city;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setCollegeName(rs.getString(2));
			this.setCity(rs.getString(3));
			this.setUniversity(rs.getString(4));
			this.setContactNo(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
