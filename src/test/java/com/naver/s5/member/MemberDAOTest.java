package com.naver.s5.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s5.AbstractTestCase;

public class MemberDAOTest extends AbstractTestCase {
	@Autowired
	private MemberDAO memberDAO;
	 
	@Test //성공
	public void daoIstnull() {
		assertNotNull(memberDAO);
	}
	
//	@Test //성공
//	public void memberLoginTest() throws Exception{
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setId("dy");
//		memberVO.setUpw("dy");
//		
//		memberVO=memberDAO.memberLogin(memberVO);
//		assertNotNull(memberVO);
//		
//	}
	
//	@Test// 성공
//	public void memberJoinTest() throws Exception{
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setId("mm");
//		memberVO.setUpw("mm");
//		memberVO.setUname("mm");
//		memberVO.setAge(20);
//		memberVO.setEmail("mm@naver.com");
//		memberVO.setPhone(010555);
//		
//		
//		
//		int result = memberDAO.memberAdd(memberVO);
//		
//		assertEquals(1, result);
//		
//		
//	}
}
