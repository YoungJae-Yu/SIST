package com.web.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.board.service.A01_Service;
import com.web.board.vo.Emp;
import com.web.board.vo.Person;

@Controller
public class A01_Controller {
	// http://localhost:5050/start
	@GetMapping("start")
	public String start() {
		return "a01_exp/a01_start";
	}
	// http://localhost:5050/bootstrap
	@GetMapping("bootstrap")
	public String a02_bootstrapTmp() {
		return "a01_exp/a02_bootstrapTmp";
	}
	// http://localhost:5050/a03_exp
	@GetMapping("a03_exp")
	public String a03_exp() {
		return "a01_exp/a03_exp";
	}
	// http://localhost:5050/a04_model
	@GetMapping("a04_model")
	public String a04_model(Model d) {
		d.addAttribute("msg", "안녕하세요");
		return "a01_exp/a04_model";
	}
	// http://localhost:5050/a05_obj_model
	@GetMapping("a05_obj_model")
	public String a05_obj_model(Model d) {
		d.addAttribute("p01", new Person("홍길동", 25, "서울"));
		return "a01_exp/a05_obj_model";
	}
	// ${p01.name} ${p01.age} ${p01.loc}
	
	@Autowired
	private A01_Service service;
	// http://localhost:5050/a06_empList
	@RequestMapping("a06_empList")
	public String a06_empList(Emp sch,Model d) {
		System.out.println(service.empList(sch).size());
		d.addAttribute("empList", service.empList(sch));
		return "a01_exp/a06_empList";
	}
}
