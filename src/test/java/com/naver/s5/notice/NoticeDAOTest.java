package com.naver.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s5.AbstractTestCase;

public class NoticeDAOTest  extends AbstractTestCase{
	@Autowired
	private NoticeDAO noticeDAO;	
	
	@Test
	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}
	@Test
	public void boardWriteTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setTitle("test title");
		noticeVO.setName("test name");
		noticeVO.setContent("test content");
		
		int result =  noticeDAO.boardWrite(noticeVO);
		
		assertEquals(1, result);
	}
	
//	@Test
//	public void boardDelete() throws Exception{
//		int result = noticeDAO.boardDelete(6);
//		assertEquals(1, result);
//	}
	
	@Test
	public void boardUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setTitle("update title");
		noticeVO.setContent("update content");
		noticeVO.setNum(7);
		
		int result = noticeDAO.boardUpdate(noticeVO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void hitUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setHit(7);
		noticeVO.setNum(7);
		
		int result = noticeDAO.hitUpdate(noticeVO);
		
		assertEquals(1, result);
	}
	
	
}
