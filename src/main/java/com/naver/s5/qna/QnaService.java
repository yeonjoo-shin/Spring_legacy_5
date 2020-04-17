package com.naver.s5.qna;

import java.util.List;

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
		return null;
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		return null;
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return 0;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return 0;
	}

}
