package com.bank.web.serviceImpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.AccountVO;
import com.bank.web.mapper.AccountMapper;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.AccountService;
import com.sun.accessibility.internal.resources.accessibility;
@Service
public class AccountServiceImpl implements AccountService {
	AccountVO account = new AccountVO();
	
	@Autowired private SqlSession sqlSession;
	@Override
	public String open(String name, int password) {
		// 1. 통장개설
		account.setName(name);
		account.setPassword(password);
		return account.toString();
	}

	@Override
	public String deposit(int money) {
		// 2. 입금
		int total = account.getMoney();
		account.setMoney(total + money);
		return account.toString();
	}

	@Override
	public String withdraw(int money) {
		// 3. 출금
		// alt + shift + m : 메소드로 추출하는 단축키
		return saveMoney(money);
	}

	private String saveMoney(int money) {
		int total = account.getMoney();
		if ((total - money) < 0) {
			System.out.println("잔액이 부족합니다. 잔액 : " + total + ", 출금액 : " + money);
			return account.toString();
		}
		account.setMoney(total - money);
		return account.toString();
	}

	@Override
	public String search() {
		// 4. 잔액조회
		return "잔액 : " + account.getMoney();
	}

	@Override
	public AccountVO getAccount(String userid) {
		AccountVO temp = new AccountVO();
		AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
		temp = mapper.selectAccount(userid);
		return temp;
	}

}
