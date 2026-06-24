package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.HostelBean;
import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.HostelModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/HostelCtl")
public class HostelCtl extends BaseCtl<HostelBean, HostelModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("ownerName"))) {
			request.setAttribute("ownerName", PropertyReader.getValue("error.require", "ownerName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("location"))) {
			request.setAttribute("location", PropertyReader.getValue("error.require", "location"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("rent"))) {
			request.setAttribute("rent", PropertyReader.getValue("error.require", "rent"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("roomType"))) {
			request.setAttribute("roomType", PropertyReader.getValue("error.require", "roomType"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected HostelBean populateBean(HttpServletRequest request) {

		HostelBean bean = new HostelBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setOwnerName(DataUtility.getString(request.getParameter("ownerName")));
		bean.setLocation(DataUtility.getString(request.getParameter("location")));
		bean.setRent(DataUtility.getInt(request.getParameter("rent")));
		bean.setRoomType(DataUtility.getString(request.getParameter("roomType")));

		populateDTO(bean, request);

		return bean;
	}
	
	@Override
	protected String getView() {
		return ORSView.HOSTEL_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.HOSTEL_LIST_CTL;
		}
		return ORSView.HOSTEL_VIEW;
	}

	@Override
	protected HostelModel getModel() {
		return new HostelModel();
	}

}
