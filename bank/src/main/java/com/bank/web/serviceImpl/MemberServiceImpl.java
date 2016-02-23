package com.bank.web.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.MemberVO;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	// 멤버변수가 모여있는 이 곳은 필드
	// 멤버변수이지만 초기값이 필요한 경우에는 줄 수 있다.
	@Autowired MemberVO member;
	// 초기화는 하나의 동작이며, 동작(기능)은 메소드 담당이다.
	private MemberVO[] beans;
	private Map<String, MemberVO> map;
	@Autowired private SqlSession sqlSession;
	
	
	public MemberServiceImpl() {}
	// 메소드 에어리어
	public MemberServiceImpl(int count) {
		// 생성자
//		beans = new MemberVO[count];
		map = new HashMap<String, MemberVO>();
	}

	public MemberVO[] getMembers() {
		return beans;
	}

	public void setMembers(MemberVO[] members) {
		this.beans = members;
	}

	@Override
	public String join(MemberVO member) {
		// 회원가입
		if (searchById(member.getUserid()) != null) {
			return "이미 존재하는 ID입니다.";
		}
		/*
		 * MemberBean bean = new MemberBean(); bean = member; beans[count] =
		 * bean; count++; return bean.toString();
		 */

		map.put(member.getUserid(), member);
		return member.getName() + " 회원 가입을 축하드립니다!";
	}

	@Override
	public MemberVO searchById(String id) {
		// 1. 아이디로 회원정보 검색
		/*
		 * MemberBean bean = null; for (int i = 0; i < this.getCount(); i++) {
		 * if (beans[i].getUserid().equals(id)) { bean = beans[i]; } } return
		 * bean;
		 */
		return map.get(id);
	}

	@Override
	public MemberVO[] searchByName(String name) {
	//public List<MemberBean> searchByName(String name) {
		// 2. 이름으로 회원정보 검색
		/*MemberBean[] tempBeans = new MemberBean[searchCountByName(name)];
		int j = 0;
		System.out.println("입력 이름 : " + name);
		for (int i = 0; i < map.size(); i++) {
			if (beans[i].getName().equals(name)) {
				System.out.println("확인됨");
				tempBeans[j] = beans[i];
				j++;
			}
		}
		return tempBeans;*/
		MemberVO[] temp = new MemberVO[searchCountByName(name)];
		int j = 0;
		for (int i = 0; i < map.size(); i++) {
			if (map.get(i).getName().equals(name)) {
				temp[j] = map.get(i);
				j++;
			}
		}
/*		List<MemberBean> temp = new ArrayList<MemberBean>();
		for (String id : map.keySet()) {
			if (map.get(id).getName().equals(name)) {
				temp.add(map.get(id));
			}
		}*/
		return temp;
	}

	@Override
	public String remove(String id) {
		// 3. 회원탈퇴
		/*for (int i = 0; i < this.getCount(); i++) {
			if (beans[i].getUserid().equals(id)) {
				beans[i] = beans[this.getCount() - 1];
				beans[this.getCount() - 1] = null;
				count--;
				return "삭제 성공";
			}
		}
		return "삭제 실패";*/
		String result = "";
		return (map.remove(id) != null) ? "삭제 성공" : "삭제 실패";
	}

	@Override
	public int countAll() {
		// 4. 전체 회원 수 조회
		return map.size();
	}

	@Override
	public int searchCountByName(String name) {
		// 5. 이름에 대한 회원 수 조회
		int tempCount = 0;
		for (int i = 0; i < map.size(); i++) {
			if (beans[i].getName().equals(name)) {
				tempCount++;
			}
		}
		return tempCount;
	}

	@Override
	public MemberVO login(MemberVO member) {
		// 로그인
		if (sqlSession == null) {
			System.out.println("세션이 NULL 입니다.");
		} else {
			System.out.println("세션이 NULL 이 아닙니다.");
		}
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		member = mapper.selectMember(member);
		
		//String result = "로그인 실패";

		/*
		if (map.containsKey(id)) { // map에 id가 존재하는지를 먼저 체크한다.
			result = ((map.get(id)).getPassword().equals(pw)) ? "로그인 성공" : "비밀번호가 일치하지 않습니다.";
		} else {
			result = "아이디가 존재하지 않거나, 잘못된 아이디입니다.";
		}
		*/
		return member;
	}

	@Override
	public String update(MemberVO member) {
		// 업데이트
		map.replace(member.getUserid(), member);
		return null;
	}
}
