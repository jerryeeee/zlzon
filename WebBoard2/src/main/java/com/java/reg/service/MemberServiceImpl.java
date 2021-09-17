package com.java.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.reg.dao.MemberDAO;
import com.java.reg.domain.MemberVO;

@Service("memberSerivce")
public class MemberServiceImpl implements MemberSerivce{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public int userInsert(MemberVO vo) {
		
	return memberDAO.memberInsert(vo);
	}

	@Override
	public MemberVO idCheck_Login(MemberVO vo) {
		
		return memberDAO.idCheck(vo);
	}

	
	
}
