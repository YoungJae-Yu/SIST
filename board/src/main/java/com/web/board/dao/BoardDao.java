package com.web.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.board.vo.Board;
import com.web.board.vo.BoardFile;
import com.web.board.vo.BoardSch;
import com.web.board.vo.Member;
// com.web.board.dao.BoardDao
@Mapper
public interface BoardDao {
	public int getTot(BoardSch sch);
	
	
	
	public List<Board> boardList(BoardSch sch);
	public Member login(Member mem);
	public int getNo();
	public int insertBoard(Board insert);
	public Board getBoard(int no);
	public void readCntUp(int no);
	public int updateBoard(Board upt);
	public int deleteBoard(int no);
	public int insertBoardFile(BoardFile ins);
	public List<String> getFnames(int no);
}
