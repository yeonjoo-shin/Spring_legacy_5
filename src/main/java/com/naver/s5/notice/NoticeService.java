package com.naver.s5.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s5.board.BoardService;
import com.naver.s5.board.BoardVO;
import com.naver.s5.board.page.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {		
		pager.makeRow(); //startrow, lastrow 계산한 메서드
		
		long totalCount = noticeDAO.boardCount(pager);//전체글의 갯수 가지고오기
		pager.makePage(totalCount);//totalcount 넘겨주기
		
		//------------------------------
		
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return noticeDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return noticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return noticeDAO.boardDelete(num);
	}
	
	

}
