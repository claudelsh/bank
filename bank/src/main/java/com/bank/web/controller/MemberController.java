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
		System.out.println("로그인 버튼을 클릭하여 이 메소드 성공");
		member.setUserid("kim");
		member.setPassword("1");
		member = service.login(member);
		System.out.println("로그인 후 이름 : " + member.getName());
		model.addAttribute("name", member.getName());
		
		return "account/myAccount";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {
		return "member/joinForm";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		member.setUserid("kim");
		member.setPassword("1");
		member = service.login(member);
		System.out.println("로그인 후 이름 : " + member.getName());
		model.addAttribute("name", member.getName());
		
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "global/home";
	}
}
