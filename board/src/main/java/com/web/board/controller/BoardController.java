package com.web.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.board.service.BoardService;
import com.web.board.vo.Board;
import com.web.board.vo.Member;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	// http://localhost:5050/boardList
	@RequestMapping("boardList")
	public String boardList(Board sch, Model d) {
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
	// location.href="${path}/boardInsert"
	// http://localhost:5050/boardInsert
	@RequestMapping("boardInsert")
	public String boardInsert(Board ins, Model d) {
		System.out.println("답글번호:"+ins.getRefno());
		if(ins.getSubject()!=null||ins.getRefno()>0) {
			d.addAttribute("msg", service.insertBoard(ins));
		}
		return "a03_boardInsert";
		// "a03_boardInsert";??
		/*
		spring.mvc.view.prefix=/WEB-INF/views/
		spring.mvc.view.suffix=.jsp
		
		/WEB-INF/views/a03_boardInsert.jsp
		
		 * */
	}
	// http://localhost:5050/boardDetail?no=3
	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam("no") int no, 
								Model d) {
		d.addAttribute("board", service.getDetail(no));
		return "a04_boardDetail";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board upt, Model d){
		d.addAttribute("msg",service.updateBoard(upt));
		d.addAttribute("board",service.getBoard(upt.getNo()));
		return "a04_boardDetail";
	}
	@GetMapping("deleteBoard")
	public String deleteBoard(@RequestParam("no") int no, Model d) {
		d.addAttribute("msg",service.deleteBoard(no));
		return "a04_boardDetail";
	}
}
