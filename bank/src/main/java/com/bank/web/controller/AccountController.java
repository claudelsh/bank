package com.bank.web.controller;

import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.web.domain.AccountVO;
import com.bank.web.domain.MemberVO;
import com.bank.web.service.AccountService;
import com.bank.web.service.AdminService;
import com.bank.web.serviceImpl.AccountServiceImpl;
import com.bank.web.serviceImpl.AdminServiceImpl;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired AccountServiceImpl accountService;
	@RequestMapping(value = "/myAccount/{userid}", method = RequestMethod.GET)
	public String myAccount(Model model, 
			@PathVariable("userid")String userid,
			HttpSession session) {
		MemberVO temp = new MemberVO();
		AccountVO acc = new AccountVO();
		temp = (MemberVO) session.getAttribute("member");
		acc = accountService.getAccount(temp.getUserid());
		System.out.println("내 계좌 정보 : " + acc.getAccountNo());
		System.out.println("내 계좌 잔액 : " + acc.getMoney());
		System.out.println("내 계좌 비밀번호 : " + acc.getPassword());
		
		model.addAttribute("message", temp.getName());
		model.addAttribute("userid", temp.getUserid());
		
		return "account/myAccount";
	}
	
	@RequestMapping(value = "/openAccount", method = RequestMethod.GET)
	public String openAccount(Model model, HttpSession session) {
		MemberVO temp = new MemberVO();
		temp = (MemberVO) session.getAttribute("member");
		model.addAttribute("message", temp.getName());
		model.addAttribute("userid", temp.getUserid());
		
		return "account/myAccount";
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public String deposit(Model model, HttpSession session) {

		return "account/myAccount";
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdraw(Model model, HttpSession session) {

		return "account/myAccount";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(Model model, HttpSession session) {

		return "account/myAccount";
	}
}
