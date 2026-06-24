package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.VehicleBean;
import com.sunilos.p4.model.VehicleModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/VehicleListCtl")
public class VehicleListCtl extends BaseListCtl<VehicleBean, VehicleModel>{

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
		return ORSView.VEHICLE_LIST_VIEW;
	}

	@Override
	protected VehicleModel getModel() {
		return new VehicleModel();
	}

}
