package com.bank.web.mapper;

import org.springframework.stereotype.Repository;

import com.bank.web.domain.MemberVO;
@Repository
public interface MemberMapper {
	public MemberVO selectMember(MemberVO member);
	public int insertMember(MemberVO member);
	public String selectUserid(String userid);
	public int update(MemberVO member);
	public int deleteMember(String id);
	
}
