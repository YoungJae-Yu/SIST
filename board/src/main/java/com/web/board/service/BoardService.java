package com.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.board.dao.BoardDao;
import com.web.board.vo.Board;
import com.web.board.vo.Member;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	public List<Board> boardList(Board sch){
		if(sch.getSubject()==null) sch.setSubject("");
		if(sch.getWriter()==null) sch.setWriter("");
		return dao.boardList(sch);
	}
	
	public Member login(Member mem) {
		return dao.login(mem);
	}
	public String insertBoard(Board insert) {
		insert.setNo(dao.getNo());
		return dao.insertBoard(insert)>0?
				"등록성공":"등록되지 않았습니다";
	}	
	public Board getDetail(int no) {
		// 조회할 때, 조회횟수 증가 처리 ..
		dao.readCntUp(no);
		return dao.getBoard(no);
	}
	public Board getBoard(int no) {
		return dao.getBoard(no);
	}
	public String updateBoard(Board upt){
		return dao.updateBoard(upt)>0?"수정성공":"수정실패";
	}
	public String deleteBoard(int no){
		return dao.deleteBoard(no)>0?"삭제성공":"삭제실패";
	}	
}
