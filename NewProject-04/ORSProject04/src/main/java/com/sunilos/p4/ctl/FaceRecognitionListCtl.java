package com.sunilos.p4.ctl;

import java.util.List;

import org.apache.log4j.Logger;

import com.sunilos.p4.bean.FaceRecognitionBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.model.FaceRecognitionModel;
import com.sunilos.p4.model.RoleModel;
import com.sunilos.p4.util.DataUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/FaceRecognitionListCtl")
public class FaceRecognitionListCtl extends BaseListCtl<FaceRecognitionBean, FaceRecognitionModel>{

	private static Logger log = Logger.getLogger(UserCtl.class);
	
	@Override
	protected void preload(HttpServletRequest request) {
		FaceRecognitionModel model = new FaceRecognitionModel();
		try {
			List l = model.list();
			request.setAttribute("statusList", l);
		} catch (ApplicationException e) {
			log.error(e);
		}
	}
	
	@Override
	protected FaceRecognitionBean populateBean(HttpServletRequest request) {

		FaceRecognitionBean bean = new FaceRecognitionBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFaceCode(DataUtility.getString(request.getParameter("faceCode")));
		bean.setUserName(DataUtility.getString(request.getParameter("userName")));
		bean.setImagePath(DataUtility.getString(request.getParameter("imagePath")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		populateDTO(bean, request);

		return bean;
	}
	
	@Override
	protected String getView() {
		return ORSView.FACERECOGNITION_VIEW;
	}

	@Override
	protected String getView(String op) {
		return ORSView.FACERECOGNITION_LIST_VIEW;
	}

	@Override
	protected FaceRecognitionModel getModel() {
		return new FaceRecognitionModel();
	}

}
