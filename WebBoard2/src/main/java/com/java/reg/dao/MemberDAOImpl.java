package com.java.reg.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.reg.domain.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public int memberInsert(MemberVO vo) {
		// insert, update, delete 모든 결과는 숫자로 나온다
		// 입력갯수, 변경갯수, 삭제갯수, (조회가 아니고 변경)
	return mybatis.insert("MemberDAO.userInsert", vo);
	}

	@Override
	public MemberVO idCheck(MemberVO vo) {
		
		return mybatis.selectOne("MemberDAO.idCheck", vo);
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		return null;
	}

}
