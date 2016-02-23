package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
import com.bank.web.serviceImpl.MemberServiceImpl;
@Controller
public class MemberController2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberService member = new MemberServiceImpl(100);
//		AdminService admin = new AdminServiceImpl();
		MemberVO bean = null;
		
		while (true) {
			System.out.println("업무 선택"
					+ "\n 1. 아이디로 회원정보 검색"
					+ "\n 2. 이름으로 회원정보 검색"
					+ "\n 3. 회원탈퇴"
					+ "\n 4. 전체 회원 수 조회"
					+ "\n 5. 이름으로 회원 수 검색"
					+ "\n 6. 회원가입"
					+ "\n 7. 로그인"
					+ "\n 8. 정보수정"
					+ "\n 9. 종료");
			
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("조회하려는 아이디 입력");
				System.out.println("조회된 회원 정보 : " + member.searchById(scanner.next()).toString());
				break;
			case 2:
				System.out.println("조회하려는 이름 입력");
				MemberVO[] members = member.searchByName(scanner.next());
				System.out.println("회원정보 : ");
				for (int i = 0; i < members.length; i++) {
					System.out.println(members[i]);
				}
				break;
			case 3:
				System.out.println("탈퇴할 아이디 입력");
				System.out.println(member.remove(scanner.next()));
				break;
			case 4:
				System.out.println("전체 회원 수 : " + member.countAll());
				break;
			case 5:
				System.out.println("검색할 이름 입력");
				System.out.println(member.searchCountByName(scanner.next()));
				break;
			case 6:
				System.out.println("회원가입");
				System.out.println("ID / 이름 / 비밀번호 / 주소 / 생년월일 입력");
				bean = new MemberVO();
				bean.setUserid(scanner.next());
				bean.setName(scanner.next());
				bean.setPassword(scanner.next());
				bean.setAddr(scanner.next());
				bean.setBirth(scanner.nextInt());
				System.out.println(member.join(bean));
				break;
			case 7:
				System.out.println("로그인");
				//System.out.println("로그인된 계정은 " + member.login(scanner.next(), scanner.next()) + "입니다.");
				break;
			case 8:
				System.out.println("정보수정");
				System.out.println("ID / 이름 / 비밀번호 / 주소 / 생년월일 입력");
				bean.setUserid(scanner.next());
				bean.setName(scanner.next());
				bean.setPassword(scanner.next());
				bean.setAddr(scanner.next());
				bean.setBirth(scanner.nextInt());
				System.out.println(member.update(bean));
				break;
			case 9:
				System.out.println("종료합니다.");return;
			default:
				System.out.println("목록에서 선택 가능합니다.");
				System.out.println("다시 선택해 주세요.");
				break;
			}
		}
	}
}
