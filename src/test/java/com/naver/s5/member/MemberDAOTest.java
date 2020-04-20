package com.naver.s5.member;

import static org.junit.Assert.*;

import java.util.List;

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
	
//	@Test
//	public void memberListTest() throws Exception{
//
//		String id ="";
//		String uname="";
//		String phone="";
//		String email="";
//		
//		for(int i=0;i<150;i++) {
//			MemberVO memberVO = new MemberVO();
//			if(i%3==0) {
//				id="jay";
//				uname="jay";
//				phone="0106666666";
//				email="jay@naver.com";
//			}else if(i%3==1) {
//				id="mark";
//				uname="mark";
//				phone="0106666667";
//				email="mark@naver.com";
//			}else {
//				id="john";
//				uname="john";
//				phone="0106666668";
//				email="john@naver.com";
//			}
//			
//			
//		
//		
//		memberVO.setId(id+i);
//		memberVO.setUname(uname);
//		memberVO.setEmail(email);
//		memberVO.setPhone(phone);
//		
//		int result = memberDAO.memberList(memberVO);
//		
//		assertEquals(1, result);
//		}	
//		
//	}
	
	@Test// 성공
	public void memberAddTest() throws Exception{

		String id ="";
		String uname="";
		String phone="";
		String email="";
		
		for(int i=0;i<150;i++) {
			MemberVO memberVO = new MemberVO();
			if(i%3==0) {
				id="jay";
				uname="jay";
				phone="0106666666";
				email="jay@naver.com";
			}else if(i%3==1) {
				id="mark";
				uname="mark";
				phone="0106666667";
				email="mark@naver.com";
			}else {
				id="john";
				uname="john";
				phone="0106666668";
				email="john@naver.com";
			}
					
		
		memberVO.setId(id+i);
		memberVO.setUpw("pw");
		memberVO.setUname(uname);
		memberVO.setAge(20);
		memberVO.setPhone(phone);
		memberVO.setEmail(email);
		
		
		int result = memberDAO.memberAdd(memberVO);
		
		assertEquals(1, result);
		}	
		
		
	}
	
//	@Test //성공
//	public void memberDeleteTest() throws Exception{
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setId("r");
//		
//		
//		int result = memberDAO.memberDelete(memberVO);
//		assertEquals(1, result);
//	}
	
	
//	@Test //진행중
//	public void memberUpdate() throws Exception{
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setId("sun");
//		memberVO.setUpw("sun");
//		memberVO.setUname("sun");
//		memberVO.setAge(20);
//		memberVO.setEmail("sun@naver.com");
//		memberVO.setPhone(010555);
//		memberVO.setId("mm");
//		
//		int result = memberDAO.memberUpdate(memberVO);
//		assertEquals(1, result);
//		
//		
//	}
	
	
	
	
	
}

