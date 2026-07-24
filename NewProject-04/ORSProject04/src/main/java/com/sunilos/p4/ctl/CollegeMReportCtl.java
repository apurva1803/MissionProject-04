package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.CollegeMBean;
import com.sunilos.p4.model.CollegeMModel;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/CollegeMReportCtl")
public class CollegeMReportCtl extends BaseReportCtl<CollegeMBean>{

	@Override
	 public List<CollegeMBean> getList() {
        CollegeMModel model = new CollegeMModel();
        @SuppressWarnings("unchecked")
        List<CollegeMBean> colleges = model.list();
        return colleges;
	}

	@Override
	public String getCompiledReportKey() {
		return ORSView.COLLEGEM_REPORT_VIEW;
	}

	 public String getView() {
	        return ORSView.COLLEGEM_REPORT_VIEW;
	    }

}
