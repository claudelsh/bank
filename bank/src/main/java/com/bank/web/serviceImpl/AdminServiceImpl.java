package com.bank.web.serviceImpl;

import com.bank.web.domain.AccountBean;
import com.bank.web.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private int count = 0;
	private AccountBean[] beans;

	public AccountBean[] getBeans() {
		return beans;
	}

	public void setBeans(AccountBean[] beans) {
		this.beans = beans;
	}

	public AdminServiceImpl() {
		beans = new AccountBean[100];
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String open(String name, int password) {
		// 1. 통장개설
		// account 인스턴스를 필드에 선언하면
		// 나중에 추가되는 값을 오버라이딩하게 된다.
		// 추가되는 개념으로 코딩하려면 지역변수로 처리하고
		// 자료구조(컬렉션)을 필드에 선언해야 한다.
		AccountBean account = new AccountBean();
		account.setName(name);
		account.setPassword(password);
		beans[count] = account;
		count++;
		return account.toString();
	}

	@Override
	public int countAll() {
		// 1. 전체 계좌 수 조회
		return this.getCount();
	}

	@Override
	public AccountBean searchAccountByAccountNo(int accountNo) {
		// 2. 계좌번호로 해당 계좌 정보 조회
		AccountBean account = null; // 이 라인에서 account는 인스턴스 개념이 아니라
											// 리턴을 받는 타입의 변수이다.
		for (int i = 0; i < this.getCount(); i++) {
			if (beans[i].getAccountNo() == accountNo) {
				account = beans[i];
			}
		}
		return account;
	}

	@Override
	public AccountBean[] searchAccountByName(String name) {
		// 3. 이름으로 계좌 정보 조회
		AccountBean[] tempBeans = new AccountBean[searchCountByName(name)];
		int j = 0;
		for (int i = 0; i < this.getCount(); i++) {
			if (beans[i].getName().equals(name)) {
				tempBeans[j] = beans[i];
				j++;
			}
		}
		return tempBeans;
	}

	@Override
	public String closeAccount(int accountNo) {
		// 4. 계좌 삭제
		if (this.searchAccountByAccountNo(accountNo) == null) {
			return "해당 계좌가 없음";
		}
		for (int i = 0; i < this.getCount(); i++) {
			if (beans[i].getAccountNo() == accountNo) {
				beans[i] = beans[this.getCount() - 1];
				beans[this.getCount() - 1] = null;
				count--;
			}
		}
		return "삭제 성공";
	}

	@Override
	public int searchCountByName(String name) {
		// 5. 이름으로 계좌 수 조회 (3번 기능을 수행하기 위해 필요한 메소드)
		int tempCount = 0;
		for (int i = 0; i < this.getCount(); i++) {
			if (beans[i].getName().equals(name)) {
				tempCount++;
			}
		}
		return tempCount;
	}

}
