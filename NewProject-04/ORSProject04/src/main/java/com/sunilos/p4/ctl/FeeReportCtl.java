package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.FeeBean;
import com.sunilos.p4.model.FeeModel;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/FeeReportCtl")
public class FeeReportCtl extends BaseReportCtl<FeeBean>{

	@Override
	public String getView() {
		return ORSView.FEE_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "FEE_LIST_COMPILED_REPORT";
	}

	@Override
	public List<FeeBean> getList() {
		FeeModel model = new FeeModel();
        @SuppressWarnings("unchecked")
        List<FeeBean> fee = model.list();
        return fee;
	}

}
