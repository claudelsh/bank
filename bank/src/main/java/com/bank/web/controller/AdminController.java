package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.domain.AccountVO;
import com.bank.web.service.AdminService;
import com.bank.web.serviceImpl.AdminServiceImpl;
@Controller
public class AdminController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AdminService admin = new AdminServiceImpl();
		
		while (true) {
			System.out.println("\n*** 업무 선택 ***"
					+ "\n 1. 전체 계좌 수 조회"
					+ "\n 2. 계좌번호로 해당 계좌 정보 조회"
					+ "\n 3. 이름으로 계좌 정보 조회"
					+ "\n 4. 계좌 삭제"
					+ "\n 5. 이름으로 계좌 수 조회"
					+ "\n 6. 계좌개설"
					+ "\n 9. 종료");
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("총 계좌 수 : " + admin.countAll());
				break;
			case 2:
				System.out.println("조회하려는 계좌번호 입력");
				System.out.println("조회한 계좌 : " + admin.searchAccountByAccountNo(scanner.nextInt()).toString());
				break;
			case 3:
				System.out.println("조회하려는 이름 입력");
				AccountVO[] accounts = admin.searchAccountByName(scanner.next());
				System.out.println("계좌정보 : ");
				for (int i = 0; i < accounts.length; i++) {
					System.out.println(accounts[i]);
				}
				break;
			case 4:
				System.out.println("삭제하려는 계좌번호 입력");
				admin.closeAccount(scanner.nextInt());
				break;
			case 5:
				System.out.println("조회하려는 이름 입력");
				System.out.println("조회한 이름 : " + admin.searchCountByName(scanner.next()));
				break;
			case 6:
				System.out.println("이름 / 비밀번호를 입력하세요.");
				System.out.println("## 계좌 개설 결과 ##\n" + admin.open(scanner.next(), scanner.nextInt()));
				break;
			case 9:System.out.println("종료합니다.");return;
			default:
				System.out.println("목록에서 선택 가능합니다.");
				System.out.println("다시 선택해 주세요.");
				break;
			}
		}
	}
}
