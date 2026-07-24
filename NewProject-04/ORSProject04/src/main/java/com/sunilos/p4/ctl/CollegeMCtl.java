package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.CollegeBean;
import com.sunilos.p4.bean.CollegeMBean;
import com.sunilos.p4.model.CollegeMModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/CollegeMCtl")
public class CollegeMCtl extends BaseCtl<CollegeMBean, CollegeMModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("collegeName"))) {
			request.setAttribute("collegeName", PropertyReader.getValue("error.require", "collegeName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("university"))) {
			request.setAttribute("university", PropertyReader.getValue("error.require", "university"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("city"))) {
			request.setAttribute("city", PropertyReader.getValue("error.require", "City"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("contactNo"))) {
			request.setAttribute("contactNo", PropertyReader.getValue("error.require", "contactNo"));
			pass = false;
		}

		return pass;
	}

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
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.COLLEGEM_LIST_CTL;
		}
		return ORSView.COLLEGEM_VIEW;
	}

	@Override
	protected CollegeMModel getModel() {
		return new CollegeMModel();
	}

}
