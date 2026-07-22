package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.ResultBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class ResultModel extends BaseModel<ResultBean>{

	private ResultBean findBystudentId(String studentId) {
		return findByUniqueColumn("STUDENT_ID", studentId);
	}
	
	@Override
	public long add(ResultBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;
		int pk = 0;

		ResultBean existbean = findBystudentId(bean.getStudentId());

		if (existbean != null) {
			throw new DuplicateRecordException("parkingCode already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO " + getTable() + " VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getStudentId());
			pstmt.setLong(3, bean.getPercentage());
			pstmt.setString(4, bean.getGrade());
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
		return pk;
	}

	@Override
	public void update(ResultBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;
		

		ResultBean existbean = findBystudentId(bean.getStudentId());

		if (existbean != null && !(bean.getId() == existbean.getId())) {
			throw new DuplicateRecordException("productName already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable() + " SET  STUDENT_ID=?,PERCENTAGE=?, GRADE=?, STATUS=?, CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?" );
			
			pstmt.setString(1, bean.getStudentId());
			pstmt.setLong(2, bean.getPercentage());
			pstmt.setString(3, bean.getGrade());
			pstmt.setString(4, bean.getStatus());
			
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
	public String getWhereClause(ResultBean bean) {
		
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getStudentId() != null && bean.getStudentId().length() > 0) {
				sql.append(" AND STUDENT_ID like '" + bean.getStudentId() + "%'");
			}
			if (bean.getStatus() != null && bean.getStatus().length() > 0) {
				sql.append(" AND STATUS like '" + bean.getStatus() + "%'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_result";
	}

	@Override
	public ResultBean getBean() {
		return new ResultBean();
	}

}
