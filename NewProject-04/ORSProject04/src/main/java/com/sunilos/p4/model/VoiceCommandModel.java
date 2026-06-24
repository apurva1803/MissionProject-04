package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.VoiceCommandBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class VoiceCommandModel extends BaseModel<VoiceCommandBean>{

	@Override
	public long add(VoiceCommandBean bean) throws ApplicationException, DuplicateRecordException {
		
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		VoiceCommandBean existbean = findByCommandName(bean.getCommandName());

		if (existbean != null) {
			throw new DuplicateRecordException("productName already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCommandName());
			pstmt.setString(3, bean.getResponse());
			pstmt.setString(4, bean.getLanguage());
			
			
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model add End");
		return pk;
	}

	@Override
	public void update(VoiceCommandBean bean) throws ApplicationException, DuplicateRecordException {
		
		log.debug("Model update Started");
		Connection conn = null;

		VoiceCommandBean existbean = findByCommandName(bean.getCommandName());

		if (existbean != null && !(bean.getId() == existbean.getId())) {
			throw new DuplicateRecordException("Record already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable() + " SET COMMAND_NAME=?, RESPONSE=?, LANGUAGE=?, CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?" );
			
			pstmt.setString(1, bean.getCommandName());
			pstmt.setString(2, bean.getResponse());
			pstmt.setString(3, bean.getLanguage());
			
			
			pstmt.setString(4, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDatetime());
			pstmt.setTimestamp(7, bean.getModifiedDatetime());
			pstmt.setLong(8, bean.getId());
			
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : update rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in update User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
		
	}

	private VoiceCommandBean findByCommandName(String commandName) {
		return findByUniqueColumn("COMMAND_NAME", commandName);
	}

	@Override
	public String getWhereClause(VoiceCommandBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getCommandName() != null && bean.getCommandName().length() > 0) {
				sql.append(" AND COMMAND_NAME like '" + bean.getCommandName() + "%'");
			}
			if (bean.getResponse() != null && bean.getResponse().length() > 0) {
				sql.append(" AND RESPONSE like '" + bean.getResponse() + "%'");
			}
			if (bean.getLanguage() != null && bean.getLanguage().length() > 0) {
				sql.append(" AND LANGUAGE like '" + bean.getLanguage() + "%'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_voicecommand";
	}

	@Override
	public VoiceCommandBean getBean() {
		return new VoiceCommandBean();
	}

}
