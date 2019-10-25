package com.exam.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;
import com.exam.dao.BoardDao;
import com.exam.vo.BoardVO;

public class DeleteFormAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteFormAction");
		
		
		// 파라미터값 가져오기  num, pageNum
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));

		// DAO 객체 준비
		BoardDao boardDao = BoardDao.getInstance();
		// 수정할 글 가져오기
		BoardVO boardVO = boardDao.getBoard(num);
		
		//뷰(jsp)에서 사용할 데이터를 request 영역객체에 저장
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("center/delete");
		forward.setRedirect(false);
		
		return forward;
	}

}
