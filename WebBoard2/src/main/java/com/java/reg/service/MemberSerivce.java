package com.java.reg.service;

import com.java.reg.domain.MemberVO;

public interface MemberSerivce {

	public int userInsert(MemberVO vo);

	public MemberVO idCheck_Login(MemberVO vo);

}
