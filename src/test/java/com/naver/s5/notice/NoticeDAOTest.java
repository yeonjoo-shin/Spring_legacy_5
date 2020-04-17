package com.naver.s5.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s5.AbstractTestCase;
import com.naver.s5.board.BoardVO;

public class NoticeDAOTest  extends AbstractTestCase{
	@Autowired
	private NoticeDAO noticeDAO;	
	
	@Test
	public void daoTest()throws Exception{
		this.boardWriteTest();
	}
		
	@Test
	public void daoIsnull() {
		assertNotNull(noticeDAO);
	}
	
	public void boardWriteTest() throws Exception{
		String name="";
		String title="";
		String content="";
		for(int i=0;i<150;i++) {
			NoticeVO noticeVO = new NoticeVO();
			if(i%3==0) {
				name="jay";
				title="phone";
				content="samsung";
			}else if(i%3==1) {
				name="mark";
				title="computer";
				content="apple";
			}else {
				name="johnny";
				title="coffee";
				content="black";
			}
			
			noticeVO.setTitle(title+i);
			noticeVO.setName(name);
			noticeVO.setContent(content+i);
			
			int result =  noticeDAO.boardWrite(noticeVO);
			
			if(i==50 || i==100) {
				Thread.sleep(1000);
			}
		}
		
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
		
		int result = noticeDAO.hitUpdate(7);
		
		assertEquals(1, result);
	}
	
	@Test
	public void boardSelectTest() throws Exception{
		BoardVO boardVO = noticeDAO.boardSelect(7);
		assertNotNull(boardVO);
		
	}
	
//	@Test
//	public void boardListTest() throws Exception{
//		//return noticeDAO.boardList();
//		
//		List<BoardVO> ar= noticeDAO.boardList();
//		assertNotEquals(0, ar.size());
//	}
	
	
}
