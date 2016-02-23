package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.service.AccountService;
import com.bank.web.service.AdminService;
import com.bank.web.serviceImpl.AccountServiceImpl;
import com.bank.web.serviceImpl.AdminServiceImpl;
@Controller
public class AccountController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AccountService account = new AccountServiceImpl();
		AdminService admin = new AdminServiceImpl();
		
		while (true) {
			System.out.println("업무 선택 : 1. 계좌개설 / 2. 입금 / 3. 출금 / 4. 잔액조회 / 5. 종료");
			
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("이름 / 비밀번호");
				System.out.println(admin.open(scanner.next(), scanner.nextInt()));
				break;
			case 2:
				System.out.println("입금 금액 입력 : ");
				System.out.println("금액 : " + account.deposit(scanner.nextInt()));
				break;
			case 3:
				System.out.println("출금 금액 입력 : ");
				System.out.println("금액 : " + account.withdraw(scanner.nextInt()));
				break;
			case 4:
				System.out.println("\n잔액 : " + account.search());
				break;
			case 5:System.out.println("종료합니다.");return;
			default:
				System.out.println("1~5번 사이에서 선택 가능합니다.");
				System.out.println("다시 선택해 주세요.");
				break;
			}
		}
	}
}
