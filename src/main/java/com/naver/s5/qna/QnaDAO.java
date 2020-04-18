package com.naver.s5.qna;

import java.util.List;
import java.util.Map;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.s5.board.BoardDAO;
import com.naver.s5.board.BoardVO;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace ="com.naver.s5.qna.QnaDAO.";
	
	@Override
	public long boardCount() throws Exception {
		return sqlSession.selectOne(Namespace+"boardCount");
	}

	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception {
		return sqlSession.selectList(Namespace+"boardList",map);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		return sqlSession.selectOne(Namespace+"boardSelect",num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlSession.insert(Namespace+"boardWrite",boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return sqlSession.delete(Namespace+"boardDelete",num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return sqlSession.update(Namespace+"boardUpdate",boardVO);
	}

	@Override
	public int hitUpdate(long num) throws Exception {
		return sqlSession.update(Namespace+"hitUpdate",num);
	}

}
