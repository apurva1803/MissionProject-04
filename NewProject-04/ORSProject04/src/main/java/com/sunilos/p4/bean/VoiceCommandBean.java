package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoiceCommandBean extends BaseBean{

	private String commandName;
	private String response;
	private String language;
	
	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String getKey() {
		return id + "";
	}

	@Override
	public String getValue() {
		return commandName;
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		
		try {
			super.setResultset(rs);
			this.setCommandName(rs.getString(2));
			this.setResponse(rs.getString(3));
			this.setLanguage(rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
