package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.HostelBean;
import com.sunilos.p4.bean.SchoolStudentBean;
import com.sunilos.p4.model.SchoolStudentModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/SchoolStudentCtl")
public class SchoolStudentCtl extends BaseCtl<SchoolStudentBean, SchoolStudentModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getValue("error.require", "email"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			request.setAttribute("mobileNo", PropertyReader.getValue("error.require", "mobileNo"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("course"))) {
			request.setAttribute("course", PropertyReader.getValue("error.require", "course"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected SchoolStudentBean populateBean(HttpServletRequest request) {

		SchoolStudentBean bean = new SchoolStudentBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
		bean.setCourse(DataUtility.getString(request.getParameter("course")));

		populateDTO(bean, request);

		return bean;
	}
	
	@Override
	protected String getView() {
		return ORSView.SCHOOLSTUDENT_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.SCHOOLSTUDENT_LIST_CTL;
		}
		return ORSView.SCHOOLSTUDENT_VIEW;
	}	

	@Override
	protected SchoolStudentModel getModel() {
		return new SchoolStudentModel();
	}

}
