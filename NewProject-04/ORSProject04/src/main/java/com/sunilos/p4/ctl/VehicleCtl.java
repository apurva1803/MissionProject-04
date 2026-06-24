package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.bean.VehicleBean;
import com.sunilos.p4.model.VehicleModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/VehicleCtl")
public class VehicleCtl extends BaseCtl<VehicleBean, VehicleModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("vehicleNo"))) {
			request.setAttribute("vehicleNo", PropertyReader.getValue("error.require", "vehicleNo"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("ownerName"))) {
			request.setAttribute("ownerName", PropertyReader.getValue("error.require", "ownerName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("model"))) {
			request.setAttribute("model", PropertyReader.getValue("error.require", "model"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("color"))) {
			request.setAttribute("color", PropertyReader.getValue("error.require", "color"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected VehicleBean populateBean(HttpServletRequest request) {

		VehicleBean bean = new VehicleBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setVehicleNo(DataUtility.getString(request.getParameter("vehicleNo")));
		bean.setOwnerName(DataUtility.getString(request.getParameter("ownerName")));
		bean.setModel(DataUtility.getString(request.getParameter("model")));
		bean.setColor(DataUtility.getString(request.getParameter("color")));

		populateDTO(bean, request);

		return bean;
	}
	
	@Override
	protected String getView() {
		return ORSView.VEHICLE_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.VEHICLE_LIST_CTL;
		}
		return ORSView.VEHICLE_VIEW;
	}

	@Override
	protected VehicleModel getModel() {
		return new VehicleModel();
	}

}
