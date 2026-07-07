package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.FaceRecognitionBean;
import com.sunilos.p4.model.FaceRecognitionModel;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/FaceRecognitionReportCtl")
public class FaceRecognitionReportCtl extends BaseReportCtl<FaceRecognitionBean>{

	@Override
	public String getView() {
		return ORSView.FACERECOGNITION_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		 return "FACERECOGNITION_LIST_COMPILED_REPORT";
	}

	@Override
	public List<FaceRecognitionBean> getList() {
		FaceRecognitionModel model = new FaceRecognitionModel();
        @SuppressWarnings("unchecked")
        List<FaceRecognitionBean> faceRecognitionBean = model.list();
        return faceRecognitionBean;
	}

}
