package com.bank.web.mapper;

import org.springframework.stereotype.Repository;

import com.bank.web.domain.MemberVO;
@Repository
public interface AccountMapper {
	public String join(MemberVO member);
	public MemberVO searchById(String id);
	public MemberVO[] searchByName(String name);
//	public List<MemberBean> searchByName(String name);
	public String remove(String id);
	public int countAll();
	public int searchCountByName(String name);
	public String login(String id, String pw);
	public String update(MemberVO member);
}
