package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.bean.ServerBean;
import com.sunilos.p4.model.ServerModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ServerCtl")
public class ServerCtl extends BaseCtl<ServerBean, ServerModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {
		
		boolean pass= true;
		
		if(DataValidator.isNull(request.getParameter("serverName"))) {
			request.setAttribute("serverName", PropertyReader.getValue("error.require","Server Name"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("ipAddress"))) {
			request.setAttribute("ipAddress", PropertyReader.getValue("error.require","IP Address"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("cpuUsage"))) {
			request.setAttribute("cpuUsage", PropertyReader.getValue("error.require","cpu Usage"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require","status"));
			pass = false;
		}
		return true;
	}
	
	@Override
	protected ServerBean populateBean(HttpServletRequest request) {
		
		ServerBean bean = new ServerBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setServerName(DataUtility.getString(request.getParameter("serverName")));
		bean.setIpAddress(DataUtility.getString(request.getParameter("ipAddress")));
		bean.setCpuUsage(DataUtility.getDouble(request.getParameter("cpuUsage")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}
	
	@Override
	protected String getView() {
		return ORSView.SERVER_VIEW;
	}

	@Override
	protected String getView(String op) {
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.SERVER_LIST_CTL;
		}
		return ORSView.SERVER_VIEW;
	}

	@Override
	protected ServerModel getModel() {
		return new ServerModel();
	}

}
