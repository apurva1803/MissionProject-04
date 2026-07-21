package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.SmartParkingBean;
import com.sunilos.p4.bean.VehicleBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class SmartParkingModel extends BaseModel<SmartParkingBean>{

	private SmartParkingBean findByParkingCode(String parkingCode) {
		return findByUniqueColumn("PARKING_CODE", parkingCode);
	}
	
	@Override
	public long add(SmartParkingBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;

		SmartParkingBean existbean = findByParkingCode(bean.getParkingCode());

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
			pstmt.setString(2, bean.getParkingCode());
			pstmt.setString(3, bean.getVehicleNumber());
			pstmt.setString(4, bean.getSlotNumber());
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
	public void update(SmartParkingBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		

		SmartParkingBean existbean = findByParkingCode(bean.getParkingCode());

		if (existbean != null && !(bean.getId() == existbean.getId())) {
			throw new DuplicateRecordException("productName already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE " + getTable() + " SET  PARKING_CODE=?,VEHICLE_NUMBER=?, SLOT_NUMBER=?, STATUS=?, CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,rhead=? WHERE ID=?" );
			
			pstmt.setString(1, bean.getParkingCode());
			pstmt.setString(2, bean.getVehicleNumber());
			pstmt.setString(3, bean.getSlotNumber());
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
	public String getWhereClause(SmartParkingBean bean) {
		StringBuffer sql = new StringBuffer();

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getParkingCode() != null && bean.getParkingCode().length() > 0) {
				sql.append(" AND PARKING_CODE like '" + bean.getParkingCode() + "%'");
			}
			if (bean.getVehicleNumber() != null && bean.getVehicleNumber().length() > 0) {
				sql.append(" AND VEHICLE_NUMBER like '" + bean.getVehicleNumber() + "%'");
			}
			if (bean.getSlotNumber() != null && bean.getSlotNumber().length() > 0) {
				sql.append(" AND SLOT_NUMBER like '" + bean.getSlotNumber() + "%'");
			}
			if (bean.getStatus() != null && bean.getStatus().length() > 0) {
				sql.append(" AND STATUS like '" + bean.getStatus() + "%'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_smartparking";
	}

	@Override
	public SmartParkingBean getBean() {
		return new SmartParkingBean();
	}

}
