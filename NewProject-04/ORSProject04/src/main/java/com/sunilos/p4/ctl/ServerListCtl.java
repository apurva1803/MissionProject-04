package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ServerBean;
import com.sunilos.p4.model.ServerModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ServerListCtl")
public class ServerListCtl extends BaseListCtl<ServerBean, ServerModel>{

	@Override
	protected ServerBean populateBean(HttpServletRequest request) {
		
		ServerBean bean = new ServerBean();

		bean.setServerName(DataUtility.getString(request.getParameter("serverName")));
		bean.setIpAddress(DataUtility.getString(request.getParameter("ipAddress")));
		bean.setCpuUsage(DataUtility.getDouble(request.getParameter("cpuUsage")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		return bean;
	}
	
	@Override
	protected String getView() {
		return getView();
	}

	@Override
	protected String getView(String op) {
		return ORSView.SERVER_LIST_VIEW;
	}

	@Override
	protected ServerModel getModel() {
		return new ServerModel();
	}

}
