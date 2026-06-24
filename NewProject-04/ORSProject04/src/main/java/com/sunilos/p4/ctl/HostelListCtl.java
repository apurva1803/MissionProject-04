package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.HostelBean;
import com.sunilos.p4.model.HostelModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/HostelListCtl")
public class HostelListCtl extends BaseListCtl<HostelBean, HostelModel>{

	@Override
	protected HostelBean populateBean(HttpServletRequest request) {

		HostelBean bean = new HostelBean();

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
		return ORSView.HOSTEL_LIST_VIEW;
	}

	@Override
	protected HostelModel getModel() {
		return new HostelModel();
	}

}
