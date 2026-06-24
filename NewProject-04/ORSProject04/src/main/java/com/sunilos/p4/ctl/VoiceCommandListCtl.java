package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.bean.VoiceCommandBean;
import com.sunilos.p4.model.ProductModel;
import com.sunilos.p4.model.VoiceCommandModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/VoiceCommandListCtl")
public class VoiceCommandListCtl extends BaseListCtl<VoiceCommandBean, VoiceCommandModel>{

	
	protected VoiceCommandBean populateBean(HttpServletRequest request) {

		VoiceCommandBean bean = new VoiceCommandBean();

		bean.setCommandName(DataUtility.getString(request.getParameter("commandName")));
		bean.setResponse(DataUtility.getString(request.getParameter("response")));
		bean.setLanguage(DataUtility.getString(request.getParameter("language")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.VOICECOMMAND_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.VOICECOMMAND_LIST_VIEW;
	}

	@Override
	protected VoiceCommandModel getModel() {
		return new VoiceCommandModel();
	}

	
	

}
