package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.CollegeMBean;
import com.sunilos.p4.model.CollegeMModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/CollegeMListCtl")
public class CollegeMListCtl extends BaseListCtl<CollegeMBean,CollegeMModel>{

	@Override
	protected CollegeMBean populateBean(HttpServletRequest request) {


		CollegeMBean bean = new CollegeMBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));

		bean.setCollegeName(DataUtility.getString(request.getParameter("collegeName")));

		bean.setUniversity(DataUtility.getString(request.getParameter("university")));

		bean.setCity(DataUtility.getString(request.getParameter("city")));

		bean.setContactNo(DataUtility.getString(request.getParameter("contactNo")));

		populateDTO(bean, request);

		return bean;
	}
	
	@Override
	protected String getView() {
		return ORSView.COLLEGEM_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.COLLEGEM_LIST_VIEW;
	}

	@Override
	protected CollegeMModel getModel() {
		return new CollegeMModel();
	}

}
