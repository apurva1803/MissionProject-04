package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ResultBean;
import com.sunilos.p4.model.ResultModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ResultCtl")
public class ResultCtl extends BaseCtl<ResultBean, ResultModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("studentId"))) {
			request.setAttribute("studentId", PropertyReader.getValue("error.require", "studentId"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("percentage"))) {
			request.setAttribute("percentage", PropertyReader.getValue("error.require", "percentage"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("grade"))) {
			request.setAttribute("grade", PropertyReader.getValue("error.require", "grade"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "status"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected ResultBean populateBean(HttpServletRequest request) {

		ResultBean bean = new ResultBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setStudentId(DataUtility.getString(request.getParameter("studentId")));
		bean.setPercentage(DataUtility.getLong(request.getParameter("percentage")));
		bean.setGrade(DataUtility.getString(request.getParameter("grade")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}
	
	@Override
	protected String getView() {
		return ORSView.RESULT_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.RESULT_LIST_CTL;
		}
		return ORSView.RESULT_VIEW;
	}

	@Override
	protected ResultModel getModel() {
		return new ResultModel();
	}

}
