package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.HostelBean;
import com.sunilos.p4.bean.UserBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class HostelModel extends BaseModel<HostelBean>{

	@Override
	public long add(HostelBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		HostelBean existbean = findBylocation(bean.getLocation());

		if (existbean != null) {
			throw new DuplicateRecordException("location already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getOwnerName());
			pstmt.setString(3, bean.getLocation());
			pstmt.setDouble(4, bean.getRent());
			pstmt.setString(5, bean.getRoomType());
			
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
	public void update(HostelBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		HostelBean beanExist = findBylocation(bean.getLocation());
		
		if (beanExist != null && beanExist.getId() != bean.getId()) {
			throw new DuplicateRecordException("location is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable() + " SET OWNER_NAME=?, LOCATION=?, RENT=?, ROOM_TYPE=?, CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?" );
			
			pstmt.setString(1, bean.getOwnerName());
			pstmt.setString(2, bean.getLocation());
			pstmt.setDouble(3, bean.getRent());
			pstmt.setString(4, bean.getRoomType());
			
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getId());
			
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Update rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating User ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
		
	}

	private HostelBean findBylocation(String location) {
		return findByUniqueColumn("LOCATION", location);
	}

	@Override
	public String getWhereClause(HostelBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getOwnerName() != null && bean.getOwnerName().length() > 0) {
				sql.append(" AND OWNER_NAME like '" + bean.getOwnerName() + "%'");
			}
			if (bean.getLocation() != null && bean.getLocation().length() > 0) {
				sql.append(" AND LOCATION like '" + bean.getLocation() + "%'");
			}
			if (bean.getRent() > 0 ) {
				sql.append(" AND STATUS = '" + bean.getRent() );
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_hostel";
	}

	@Override
	public HostelBean getBean() {
		return new HostelBean();
	}

}
