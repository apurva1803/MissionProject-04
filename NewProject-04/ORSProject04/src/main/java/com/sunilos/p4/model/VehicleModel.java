package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.VehicleBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class VehicleModel extends BaseModel<VehicleBean>{

	@Override
	public long add(VehicleBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;

		VehicleBean existbean = findByModel(bean.getModel());

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
			pstmt.setString(2, bean.getVehicleNo());
			pstmt.setString(3, bean.getOwnerName());
			pstmt.setString(4, bean.getModel());
			pstmt.setString(5, bean.getColor());
			
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

	private VehicleBean findByModel(String model) {
		return findByUniqueColumn("MODEL", model);
	}

	@Override
	public void update(VehicleBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;
		

		VehicleBean existbean = findByModel(bean.getModel());

		if (existbean != null && !(bean.getId() == existbean.getId())) {
			throw new DuplicateRecordException("productName already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable() + " SET VEHICLE_NO=?, OWNER_NAME=?, MODEL=?, COLOR=?, CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?" );
			
			pstmt.setString(1, bean.getVehicleNo());
			pstmt.setString(2, bean.getOwnerName());
			pstmt.setString(3, bean.getModel());
			pstmt.setString(4, bean.getColor());
			
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
		log.debug("Model update End");
		
	}

	@Override
	public String getWhereClause(VehicleBean bean) {
		
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getOwnerName() != null && bean.getOwnerName().length() > 0) {
				sql.append(" AND OWNER_NAME like '" + bean.getOwnerName() + "%'");
			}
			if (bean.getColor() != null && bean.getColor().length() > 0) {
				sql.append(" AND COLOR like '" + bean.getColor() + "%'");
			}
			if (bean.getModel() != null && bean.getModel().length() > 0) {
				sql.append(" AND MODEL like '" + bean.getModel() + "%'");
			}
			if (bean.getVehicleNo() != null && bean.getVehicleNo().length() > 0) {
				sql.append(" AND VEHICLE_NO like '" + bean.getVehicleNo() + "%'");
			}
		}

		return sql.toString();
	
	}

	@Override
	public String getTable() {
		return "st_vehicle";
	}

	@Override
	public VehicleBean getBean() {
		return new VehicleBean();
	}

}
