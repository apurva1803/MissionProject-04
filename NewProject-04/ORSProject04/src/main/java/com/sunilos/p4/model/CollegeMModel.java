package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.CollegeMBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class CollegeMModel extends BaseModel<CollegeMBean>{

	private CollegeMBean findByContactNo(String contactNo) {
		return findByUniqueColumn("CONTACT_NO", contactNo);
	}
	
	@Override
	public long add(CollegeMBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		CollegeMBean existbean = findByContactNo(bean.getContactNo());

		if (existbean != null) {
			throw new DuplicateRecordException("Contact No already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getCollegeName());
			pstmt.setString(3, bean.getCity());
			pstmt.setString(4, bean.getUniversity());
			pstmt.setString(5, bean.getContactNo());
			
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
		return pk;
	}

	@Override
	public void update(CollegeMBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		

		CollegeMBean existbean = findByContactNo(bean.getContactNo());

		if (existbean != null && !(bean.getId() == existbean.getId())) {
			throw new DuplicateRecordException("Student id already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable() + " SET  COLLEGE_NAME=?,CITY=?, UNIVERSITY=?, CONTACT_NO=?, CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?" );
			
			pstmt.setString(1, bean.getCollegeName());
			pstmt.setString(2, bean.getCity());
			pstmt.setString(3, bean.getUniversity());
			pstmt.setString(4, bean.getContactNo());
			
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getId());
			
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : update rollback exception " + ex.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("Exception : Exception in update User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}

	@Override
	public String getWhereClause(CollegeMBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getUniversity() != null && bean.getUniversity().length() > 0) {
				sql.append(" AND UNIVERSITY like '" + bean.getUniversity() + "%'");
			}
			if (bean.getContactNo() != null && bean.getContactNo().length() > 0) {
				sql.append(" AND CONTACT_NO like '" + bean.getContactNo() + "%'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_collegem";
	}

	@Override
	public CollegeMBean getBean() {
		return new CollegeMBean();
	}

}
