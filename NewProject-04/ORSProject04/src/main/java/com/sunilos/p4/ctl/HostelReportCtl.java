package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.HostelBean;
import com.sunilos.p4.model.HostelModel;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/HostelReportCtl")
public class HostelReportCtl extends BaseReportCtl<HostelBean>{

	@Override
	public String getView() {
		return ORSView.HOSTEL_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "HOSTEL_LIST_COMPILED_REPORT";
	}

	@Override
	public List<HostelBean> getList() {
		HostelModel model = new HostelModel();
        @SuppressWarnings("unchecked")
        List<HostelBean> hostel = model.list();
        return hostel;
	}

}
