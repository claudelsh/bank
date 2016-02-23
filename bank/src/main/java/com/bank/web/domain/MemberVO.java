package com.bank.web.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class MemberVO {
	private String userid;
	private String name;
	private String password;
	private String addr;
	private int birth;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ 회원정보 ] " + this.getUserid() + " / " + this.getName() + " / "
				+ this.getAddr() + " / " + this.getBirth();
	}
}
