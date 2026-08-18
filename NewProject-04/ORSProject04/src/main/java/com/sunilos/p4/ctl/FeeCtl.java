package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.FeeBean;
import com.sunilos.p4.bean.ResultBean;
import com.sunilos.p4.model.FeeModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/FeeCtl")
public class FeeCtl extends BaseCtl<FeeBean, FeeModel>{

	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("studentId"))) {
			request.setAttribute("studentId", PropertyReader.getValue("error.require", "studentId"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("amount"))) {
			request.setAttribute("amount", PropertyReader.getValue("error.require", "amount"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("paymentDate"))) {
			request.setAttribute("paymentDate", PropertyReader.getValue("error.require", "paymentDate"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "status"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected FeeBean populateBean(HttpServletRequest request) {

		FeeBean bean = new FeeBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setStudentId(DataUtility.getString(request.getParameter("studentId")));
		bean.setAmount(DataUtility.getLong(request.getParameter("amount")));
		bean.setPaymentDate(DataUtility.getDate(request.getParameter("paymentDate")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}
	
	
	@Override
	protected String getView() {
		return ORSView.FEE_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.FEE_LIST_CTL;
		}
		return ORSView.FEE_VIEW;
	}

	@Override
	protected FeeModel getModel() {
		return new FeeModel();
	}
	

}
