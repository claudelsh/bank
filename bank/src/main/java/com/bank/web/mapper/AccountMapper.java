package com.bank.web.mapper;

import org.springframework.stereotype.Repository;

import com.bank.web.domain.AccountVO;
import com.bank.web.domain.MemberVO;
@Repository
public interface AccountMapper {
	
	public AccountVO selectAccount(String userid);
}
