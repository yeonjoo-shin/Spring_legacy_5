package com.naver.s5.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.s5.AbstractTestCase;
import com.naver.s5.board.BoardVO;


public class QnaDAOTest  extends AbstractTestCase{
		@Autowired
		private QnaDAO qnaDAO;
		
//		@Test
//		public void daoTest() throws Exception{
//			this.boardWriteTest();
//		}
		
		@Test
		public void daoIsnull() {
			assertNotNull(qnaDAO);
		}
		
//		public void boardWriteTest() throws Exception{
//			String name="";
//			String title="";
//			String content="";
//			for(int i=0;i<150;i++) {
//				QnaVO qnaVO = new QnaVO();
//				if(i%3==0) {
//					name="jay";
//					title="phone";
//					content="samsung";
//				}else if(i%3==1) {
//					name="mark";
//					title="computer";
//					content="apple";
//				}else {
//					name="johnny";
//					title="coffee";
//					content="black";
//				}
//				
//				qnaVO.setTitle(title+i);
//				qnaVO.setName(name);
//				qnaVO.setContent(content+i);
//				
//				int result =  qnaDAO.boardWrite(qnaVO);
//				
//				if(i==50 || i==100) {
//					Thread.sleep(1000);
//				}
//			}
//		}
		

		
		@Test
		public void boardSelectTest() throws Exception{
			BoardVO boardVO = qnaDAO.boardSelect(150);
			assertNotNull(boardVO);
		}
		
		
		
//		@Test
//		public void boardUpdateTest() throws Exception{
//			QnaVO qnaVO = new QnaVO();
//			
//			qnaVO.setTitle("update title");
//			qnaVO.setContent("update content");
//			qnaVO.setNum(150);
//			
//			int result = qnaDAO.boardUpdate(qnaVO);
//			
//			assertEquals(1, result);
//		}
		
//		@Test
//		public void hitUpdateTest() throws Exception{
//			QnaVO qnaVO = new QnaVO();
//			
//			qnaVO.setHit(7);
//			qnaVO.setNum(150);
//			
//			int result = qnaDAO.hitUpdate(150);
//			
//			assertEquals(1, result);
//		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
