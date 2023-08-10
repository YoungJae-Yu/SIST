package com.web.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.board.service.BoardService;
import com.web.board.vo.Board;
import com.web.board.vo.BoardSch;
import com.web.board.vo.Member;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	// http://localhost:5050/boardList
	@RequestMapping("boardList")
	public String boardList(@ModelAttribute("sch") BoardSch sch, Model d) {
		d.addAttribute("boardList", service.boardList(sch));
		return "a01_boardList";
	}
	// http://localhost:5050/login
	@RequestMapping("login")
	public String login(Member mem, HttpSession session, Model d) {
		String msg = "";
		if(mem.getId()!=null) { // 초기화면과 구분..			
			msg = "로그인 실패";
			Member login = service.login(mem);
			if(login!=null) {
				msg = "로그인 성공";
				session.setAttribute("mem", login);
			}
			d.addAttribute("msg", msg);
		}
		
		return "a02_login";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("mem")!=null) {
			session.removeAttribute("mem");
		}
		return "redirect:/login";
		// controller에서 메서드로 기능 메서드 호출시..
		/*
		forward: 요청값 전달
		redirect : 요청값 전달하지 않고 호출..
		 * */
	}
	// http://localhost:5050/boardInsertFrm
	// 글등록화면 로딩/답글화면 로딩
	@RequestMapping("boardInsertFrm")
	public String boardInsertFrm(Board ins) {
		return "a03_boardInsert";
	}	
	
	// http://localhost:5050/boardInsert
	// 글등록 DB 처리
	@RequestMapping("boardInsert")
	public String boardInsert(Board ins, Model d) {
		d.addAttribute("msg", service.insertBoard(ins));
		return "a03_boardInsert";
	}
	// http://localhost:5050/boardDetail?no=0
	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam("no") int no, 
								Model d) {
		d.addAttribute("board", service.getDetail(no));
		return "a04_boardDetail";
	}
	// boardUpdate
	@PostMapping("boardUpdate")
	public String boardUpdate(Board upt,Model d){
		d.addAttribute("msg", service.updateBoard(upt));
		d.addAttribute("board",service.getBoard(upt.getNo()));
		
		return "a04_boardDetail";
	}  
	// boardDelete?no=4
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam("no") int no,
							   Model d) {
		d.addAttribute("msg", service.deleteBoard(no));
		return "a04_boardDetail"; 
	}	
	// download.do?fname="+
	@RequestMapping("download.do")
	public String download(@RequestParam("fname") 
			String fname, Model d) {
		d.addAttribute("downloadFile", fname);
		System.out.println("호출!!!!");
		return "downloadViewer";
	}	
}
