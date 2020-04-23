package com.naver.s5.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s5.AbstractTestCase;
import com.naver.s5.board.file.BoardFileDAO;
import com.naver.s5.board.file.BoardFileVO;

public class BoardFileDAOTest extends AbstractTestCase {
	
	@Autowired
	private BoardFileDAO boardFileDAO;	
	
	@Test
	public void daoisnull() {
		assertNotNull(boardFileDAO);
	}
	
	@Test
	public void fileInsertTest() throws Exception{
		BoardFileVO boardFileVO = new BoardFileVO();
		
		boardFileVO.setFileNum(3);
		boardFileVO.setNum(3);
		boardFileVO.setFileName("jayjay");
		boardFileVO.setOriName("jayjay");
		boardFileVO.setBoard(2);
		
		int result = boardFileDAO.fileInsert(boardFileVO);
		assertEquals(1, result);
		
	}
	
	
}
