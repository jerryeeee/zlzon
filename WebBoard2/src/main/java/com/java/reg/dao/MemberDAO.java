package com.java.reg.dao;

import com.java.reg.domain.MemberVO;

public interface MemberDAO {

	// 회원가입
	public int memberInsert(MemberVO vo);

	/**
	 * id 중복체트 기능 구현
	 */
	public MemberVO idCheck(MemberVO vo);

	/**
	 * 
	 * 
	 * /** 로그인 확인 기능 구현
	 */
	MemberVO memberLogin(MemberVO vo);

}
