package com.naver.s5.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s5.AbstractTestCase;
import com.naver.s5.member.memberFile.MemberFileDAO;
import com.naver.s5.member.memberFile.MemberFileVO;

public class MemberFileDAOTest extends AbstractTestCase {

	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Test
	public void daoisnull() {
		assertNotNull(memberFileDAO);
	}
	
	@Test
	public void fileInsertTest() throws Exception {
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("mm2");
		memberFileVO.setFileName("mm2_file");
		memberFileVO.setOriName("mm2_ori");
		
		int result=memberFileDAO.fileInsert(memberFileVO);
		assertEquals(1, result);
	
	}

}
