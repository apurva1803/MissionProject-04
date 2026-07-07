package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.ServerBean;
import com.sunilos.p4.model.ServerModel;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/ServerReportCtl")
public class ServerReportCtl extends BaseReportCtl<ServerBean>{

	@Override
	public String getView() {
		return ORSView.SERVER_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "SERVER_LIST_COMPILED_REPORT";
	}

	@Override
	public List<ServerBean> getList() {
		ServerModel model = new ServerModel();
        @SuppressWarnings("unchecked")
        List<ServerBean> server = model.list();
        return server;
	}

}
