package com.java.reg.dao;

import com.java.reg.domain.MemberVO;

public interface MemberDAO {

	// ȸ������
	public int memberInsert(MemberVO vo);

	/**
	 * id �ߺ�üƮ ��� ����
	 */
	public MemberVO idCheck(MemberVO vo);

	/**
	 * 
	 * 
	 * /** �α��� Ȯ�� ��� ����
	 */
	MemberVO memberLogin(MemberVO vo);

}
