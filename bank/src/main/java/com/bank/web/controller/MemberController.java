package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
import com.bank.web.serviceImpl.MemberServiceImpl;
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired MemberVO member;
	@Autowired MemberService service;

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(Model model) {
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam("userid")String userid,
			@RequestParam("password")String password,
			Model model) {
		System.out.println("넘어온 아이디 " + userid);
		System.out.println("넘어온 비밀번호 " + password);
		MemberVO member = new MemberVO();
		String existId = service.existCheck(userid);
		String message = "", page = "";
		if (existId == null) {
			model.addAttribute("message", "아이디가 존재하지 않습니다.");
			page = "member/loginForm";
		} else {
			member.setUserid(userid);
			member.setPassword(password);
			member = service.login(member);
			
			if (member == null) {
				message = "비밀번호가 일치하지 않습니다.";
				page = "member/loginForm";
			} else {
				message = member.getName();
				page = "account/myAccount";
			}
		}
		model.addAttribute("message", message);
		return "account/myAccount";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		return "member/joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(
			@RequestParam("userid")String userid,
			@RequestParam("password")String password,
			@RequestParam("name")String name,
			@RequestParam("addr")String addr,
			@RequestParam("birth")String birth,
			Model model) {
		member.setUserid(userid);
		member.setPassword(password);
		member.setName(name);
		member.setAddr(addr);
		member.setBirth(Integer.parseInt(birth));
		// String 타입을 int 타입으로 변환 - Integer.parseInt()
		// String.valuseOf() - int 타입을 Spring 타입으로 전환
		
		int result = service.join(member);
		if (result == 1) {
			model.addAttribute("name", name);
		} else {
			System.out.println("회원가입 실패");
		}
		System.out.println("로그인 후 이름 : " + member.getName());
		model.addAttribute("name", member.getName());
		
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "global/home";
	}
}
