package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.bean.ServerBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class ServerModel extends BaseModel<ServerBean>{

	@Override
	public long add(ServerBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		ServerBean existbean = findByProductName(bean.getServerName());

		if (existbean != null) {
			throw new DuplicateRecordException("productName already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getServerName());
			pstmt.setString(3, bean.getIpAddress());
			pstmt.setDouble(4, bean.getCpuUsage());
			pstmt.setString(5, bean.getStatus());
			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
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
	public void update(ServerBean bean) throws ApplicationException, DuplicateRecordException {
		
		log.debug("Model update Started");
		Connection conn = null;
		int pk = 0;

		ServerBean existbean = findByProductName(bean.getServerName());

		if (existbean != null) {
			throw new DuplicateRecordException("productName already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable() + " SET SERVER_NAME=?, IP_ADDRESS=?, CPU_USAGE=?, STATUS=? CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?" );
			
			pstmt.setString(1, bean.getServerName());
			pstmt.setString(2, bean.getIpAddress());
			pstmt.setDouble(3, bean.getCpuUsage());
			pstmt.setString(4, bean.getStatus());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setInt(9, pk);
			
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

	@Override
	public String getWhereClause(ServerBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getServerName() != null && bean.getServerName().length() > 0) {
				sql.append(" AND SERVER_NAME like '" + bean.getServerName() + "%'");
			}
			if (bean.getIpAddress() != null && bean.getIpAddress().length() > 0) {
				sql.append(" AND IP_ADDRESS like '" + bean.getIpAddress() + "%'");
			}
			if (bean.getStatus() != null && bean.getStatus().length() > 0) {
				sql.append(" AND STATUS like '" + bean.getStatus() + "%'");
			}
		}

		return sql.toString();
	}
	
	public ServerBean findByProductName(String serverName) {
		return findByUniqueColumn("SERVER_NAME", serverName);
	}
	
	@Override
	public String getTable() {
		return "st_server";
	}

	@Override
	public ServerBean getBean() {
		return new ServerBean();
	}

}
