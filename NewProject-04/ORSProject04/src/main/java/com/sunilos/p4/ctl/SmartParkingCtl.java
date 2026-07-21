package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.SmartParkingBean;
import com.sunilos.p4.model.SmartParkingModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/SmartParkingCtl")
public class SmartParkingCtl extends BaseCtl<SmartParkingBean, SmartParkingModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("parkingCode"))) {
			request.setAttribute("parkingCode", PropertyReader.getValue("error.require", "parkingCode"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("vehicleNumber"))) {
			request.setAttribute("vehicleNumber", PropertyReader.getValue("error.require", "vehicleNumber"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("slotNumber"))) {
			request.setAttribute("slotNumber", PropertyReader.getValue("error.require", "slotNumber"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "status"));
			pass = false;
		}

		return pass;
	}

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
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.SMARTPARKING_LIST_CTL;
		}
		return ORSView.SMARTPARKING_VIEW;
	}

	@Override
	protected SmartParkingModel getModel() {
		return new SmartParkingModel();
	}

}
