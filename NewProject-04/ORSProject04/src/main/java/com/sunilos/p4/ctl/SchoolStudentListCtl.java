package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.SchoolStudentBean;
import com.sunilos.p4.model.SchoolStudentModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/SchoolStudentListCtl")
public class SchoolStudentListCtl extends BaseListCtl<SchoolStudentBean, SchoolStudentModel> {

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
		return ORSView.SCHOOLSTUDENT_LIST_VIEW;
	}

	@Override
	protected SchoolStudentModel getModel() {
		return new SchoolStudentModel();
	}

}
