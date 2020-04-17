package com.naver.s5.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.s5.board.BoardService;
import com.naver.s5.board.BoardVO;


@Service
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardVO> boardList(int curPage) throws Exception {
		int startRow = (curPage-1)*10+1;
		int lastRow = curPage*10;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		//---
		long totalCount = qnaDAO.boardCount();
		System.out.println("totalCount : " +totalCount);
		long totalPage = totalCount/10;
		if(totalPage%10 !=0) {
			totalPage++;
		}
		System.out.println("totalPage : " + totalPage);
		
		return qnaDAO.boardList(map);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		qnaDAO.hitUpdate(num);
		return qnaDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return qnaDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return qnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return qnaDAO.boardDelete(num);
	}

}
