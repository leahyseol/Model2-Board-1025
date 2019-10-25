package com.exam.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;

public class ReWriteFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReWriteFormAction");
		
		//파라미터 가져오기
//		String reRef = request.getParameter("reRef");
//		String reLef = request.getParameter("reLef");
//		String reSeq = request.getParameter("reSeq");
//		
		//뷰에서 필요한 데이터를 request 영역객체에 저장
//		request.setAttribute("reRef", reRef);
//		request.setAttribute("reLef", reLef);
//		request.setAttribute("reSeq", reSeq);
		
		ActionForward forward = new ActionForward();
		forward.setPath("center/reWrite");
		forward.setRedirect(false);
		return forward;
	}

}
