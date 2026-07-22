package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ResultBean;
import com.sunilos.p4.model.ResultModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ResultListCtl")
public class ResultListCtl extends BaseListCtl<ResultBean, ResultModel>{

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
		return ORSView.RESULT_LIST_VIEW;
	}

	@Override
	protected ResultModel getModel() {
		return new ResultModel();
	}

}
