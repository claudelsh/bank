package com.bank.web.service;

import com.bank.web.domain.AccountVO;

public interface AccountService {
	// DB 에서 DRUD
	// create
	// read
	// update
	// delete
	
	// 1. 통장 개설
	public String open(String name, int password);
	// 2. 입금
	public String deposit(int money);
	// 3. 출금
	public String withdraw(int money);
	// 4. 조회
	public String search();
	AccountVO getAccount(String userid);
}
