package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.SmartParkingBean;
import com.sunilos.p4.model.SmartParkingModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/SmartParkingListCtl")
public class SmartParkingListCtl extends BaseListCtl<SmartParkingBean, SmartParkingModel>{

	@Override
	protected SmartParkingBean populateBean(HttpServletRequest request) {

		SmartParkingBean bean = new SmartParkingBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setParkingCode(DataUtility.getString(request.getParameter("parkingCode")));
		bean.setVehicleNumber(DataUtility.getString(request.getParameter("vehicleNumber")));
		bean.setSlotNumber(DataUtility.getString(request.getParameter("slotNumber")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}
	
	@Override
	protected String getView() {
		return ORSView.SMARTPARKING_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.SMARTPARKING_LIST_VIEW;
	}

	@Override
	protected SmartParkingModel getModel() {
		return new SmartParkingModel();
	}

}
