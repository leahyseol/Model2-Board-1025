package com.exam.controller.board;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;
import com.exam.dao.BoardDao;
import com.exam.vo.BoardVO;

public class ReWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReWriteAction");
		
		//액션테그로 자바빈 객체 형성 
		BoardVO boardVO = new BoardVO();
		
		//파라미터 가져와서 VO에 저장
		boardVO.setUsername(request.getParameter("username"));
		boardVO.setPasswd(request.getParameter("passwd"));
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setContent(request.getParameter("content"));
		boardVO.setReRef(Integer.parseInt(request.getParameter("reRef")));
		boardVO.setReLev(Integer.parseInt(request.getParameter("reLev")));
		boardVO.setReSeq(Integer.parseInt(request.getParameter("reSeq")));
		
		boardVO.setRegDate(new Timestamp(System.currentTimeMillis()));
		boardVO.setIp(request.getRemoteAddr());
		
		//boardDao 객체 준비
		BoardDao boardDao=BoardDao.getInstance();
		
		//게시글 번호 생성하는 메소느 호출
		int num=boardDao.nextBoardNum();
		//생성된 번호를 자바빈 글번호 필드에 설정
		boardVO.setNum(num);

		//답글쓰기 메소드 호출
		boardDao.reInsertBoard(boardVO);

		//이동 NOTICE.JSP
		ActionForward forward = new ActionForward();
		forward.setPath("notice.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
