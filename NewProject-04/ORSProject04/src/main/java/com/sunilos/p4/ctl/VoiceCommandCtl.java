package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.bean.VoiceCommandBean;
import com.sunilos.p4.model.VoiceCommandModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/VoiceCommandCtl")
public class VoiceCommandCtl extends BaseCtl<VoiceCommandBean, VoiceCommandModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("commandName"))) {
			request.setAttribute("commandName", PropertyReader.getValue("error.require", "commandName"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("response"))) {
			request.setAttribute("response", PropertyReader.getValue("error.require", "response"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("language"))) {
			request.setAttribute("language", PropertyReader.getValue("error.require", "language"));
			pass = false;
		}

		return pass;
	}

	@Override
	protected VoiceCommandBean populateBean(HttpServletRequest request) {

		VoiceCommandBean bean = new VoiceCommandBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
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
		if (OP_CANCEL.equalsIgnoreCase(op)) {
			return ORSView.VOICECOMMAND_LIST_CTL;
		}
		return ORSView.VOICECOMMAND_VIEW;
	}

	@Override
	protected VoiceCommandModel getModel() {
		return new VoiceCommandModel();
	}

}
