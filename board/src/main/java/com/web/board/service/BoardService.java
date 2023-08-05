package com.web.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.board.dao.BoardDao;
import com.web.board.vo.Board;
import com.web.board.vo.BoardFile;
import com.web.board.vo.BoardSch;
import com.web.board.vo.Member;

@Service
public class BoardService {
	@Value("${upload}")
	private String path;
	@Autowired
	private BoardDao dao;
	public List<Board> boardList(BoardSch sch){
//		// 2. 페이징처리1단계
//		private int  count; // 전체 데이터건수
		sch.setCount(dao.getTot(sch));
//		private int pageSize; // 한 페이지에 보여줄 데이터 건수
		// 초기데이터로 요청값이 없더라도 5건수 보이게 처리
		if(sch.getPageSize()==0) sch.setPageSize(5);
//		private int pageCount;// 총 페이지 수 count/pageSize
		/*
		한번에 보여줄 데이터 건수가 5
		총데이터 20건 ==> 4
		총데이터 23건 ==> 5
		sch.getPageCount()/sch.getPageSize()
		정수/정수*1.0
		Math.ceil(정수/(double)정수)
		*/
		int pageCnt = (int)Math.ceil(sch.getPageCount()/(double)sch.getPageSize());
		sch.setPageCount(pageCnt);
//		private int curPage;// 클릭한 현재 페이지 번호
//		private int start;// 현재 페이지 시작번호
//		private int end;// 현재 페이지 마지막번호
//
//		// 3. 페이징블럭처리2단계
//		private int blockSize;// 한번에 보여줄 block의 크기
//		private int startBlock;// block 시작번호
//		private int endBlock;// block 마지막번호
		
		
		
		
		if(sch.getSubject()==null) sch.setSubject("");
		if(sch.getWriter()==null) sch.setWriter("");
		return dao.boardList(sch);
	}
	
	public Member login(Member mem) {
		return dao.login(mem);
	}
	public String insertBoard(Board insert) {
		int no = dao.getNo();
		insert.setNo(no);
		String msg = "업로드 성공";
		for(MultipartFile mf:insert.getReport() ) {
			String fname = mf.getOriginalFilename();
			if(fname!=null && !fname.trim().equals("")) {
				File f = new File(path+fname);
				try {
					mf.transferTo(f);
					
				} catch (IllegalStateException e) {
					msg = "예외발생1:"+e.getMessage();
				} catch (IOException e) {
					msg = "예외발생2:"+e.getMessage();
				}
				if(msg.equals("업로드 성공")) {
					dao.insertBoardFile(
						new BoardFile(no,fname,insert.getSubject()));
				}
			}
		}
		System.out.println("파일첨부내용:"+msg);
		return dao.insertBoard(insert)>0?
				"등록성공":"등록되지 않았습니다";
	}	
	public Board getDetail(int no) {
		// 조회할 때, 조회횟수 증가 처리..
		dao.readCntUp(no);
		Board b = dao.getBoard(no);
		b.setFnames(dao.getFnames(no));
		System.out.println("# 게시물의 파일 정보 #");
		for(String fname:b.getFnames()) {
			System.out.println(fname);
		}
		
		
		
		
		
		
		return b;
	}
	public Board getBoard(int no) {
		return dao.getBoard(no);
	}	
	public String updateBoard(Board upt) {
		return dao.updateBoard(upt)>0?
					"수정완료":"수정되지 않았습니다.";
	}
	public String deleteBoard(int no) {
		return dao.deleteBoard(no)>0?
				"삭제완료":"삭제되지 않았습니다.";
	}

	
	

}
