package com.exam.controller.board;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Action;
import com.exam.controller.ActionForward;
import com.exam.dao.BoardDao;
import com.exam.vo.BoardVO;

public class WriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//자바빈 객체 생성
		BoardVO boardVO = new BoardVO();
		
		//파라미터값 자바빈에 저장
		boardVO.setUsername(request.getParameter("username"));
		boardVO.setPasswd(request.getParameter("passwd"));
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setContent(request.getParameter("content"));
		
		//글 등록날짜, ip주소값 저장
		boardVO.setRegDate(new Timestamp(System.currentTimeMillis()));
		boardVO.setIp(request.getRemoteAddr());
		
		BoardDao boardDao = BoardDao.getInstance();
		
		int num = boardDao.nextBoardNum();
		// 생성된 번호를 자바빈 글번호 필드에 설정
		boardVO.setNum(num);
		boardVO.setReadcount(0); // 조회수 0

		//주글일 경우
		boardVO.setReRef(num); // 주글쓰기에서 글그룹번호는 글번호와 동일함
		boardVO.setReLev(0); // 주글은 들여쓰기 레벨 0
		boardVO.setReSeq(0); // 주글은 글그룹 안에서의 순서 0
		
		//게시글 한개 등록하는 메소드 호출 insertBoard(boardVO)
		boardDao.insertBoard(boardVO); 
		
		//이동 notice.do
		ActionForward forward = new ActionForward();
		forward.setPath("notice.do");
		forward.setRedirect(true);
		
		return null;
	}

}
